package edu.mum.wap.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mum.wap.dao.UserDAO;
import edu.mum.wap.model.Result;
import edu.mum.wap.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/login", "/register"})
public class LoginController extends HttpServlet{
    private static final String LOGIN = "/login";
    private static final String REGISTER = "/register";
    private UserDAO dao;
    private ObjectMapper mapper;
    @Override
    public void init() throws ServletException {
        dao = new UserDAO();
        mapper = new ObjectMapper();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getRequestURI();
        resp.setContentType("application/json;charset=UTF-8");
        String json;
        if(param.equals(LOGIN)) {
            User user = new User(req.getParameter("uname"), req.getParameter("upassword"));
            if (dao.verifyUser(user)) {
                json = mapper.writeValueAsString(new Result(true));
            } else {
                json = mapper.writeValueAsString(new Result(false));
            }
        } else {
            Result result;
            resp.setContentType("application/json;charset=UTF-8");
            String pass = req.getParameter("upassword");
            String repass = req.getParameter("upasswordCheck");
            String name = req.getParameter("uname");
            String email = req.getParameter("uemail");
            if(pass.equals(repass)) {
                User user = new User(name, pass, email);
                result = dao.addUser(user);
            } else {
                result = new Result(false, "Re-checked password is not matched");
            }
            json = mapper.writeValueAsString(result);
        }
        resp.getWriter().write(json);
    }
}
