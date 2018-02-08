package edu.mum.wap.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mum.wap.dao.UserDAO;
import edu.mum.wap.model.Result;
import edu.mum.wap.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

import static java.lang.Boolean.*;

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
            HttpSession session = req.getSession();
            String name = req.getParameter("uname");
            String pass = req.getParameter("upassword");
            boolean remember = Boolean.parseBoolean(req.getParameter("remember"));
            User user = new User(name, pass);
            if (dao.verifyUser(user)) {
                session.setAttribute("username", name);
                session.setMaxInactiveInterval(30*60);
                Cookie cookie = new Cookie("login_id", name);
                cookie.setMaxAge(-1); //session cookie
                if(remember) {
                    Cookie c = new Cookie("name", name);
                    c.setMaxAge(60*60*24*30);
                    resp.addCookie(c);
                }
                resp.addCookie(cookie);
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
