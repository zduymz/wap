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

@WebServlet("/register")
public class RegisterController extends HttpServlet {
    private UserDAO dao;
    private ObjectMapper mapper;
    @Override
    public void init() throws ServletException {
        dao = new UserDAO();
        mapper = new ObjectMapper();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = "";
        Result result = null;
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
        resp.getWriter().write(json);
    }
}
