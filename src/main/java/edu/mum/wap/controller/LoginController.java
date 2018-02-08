package edu.mum.wap.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mum.wap.dao.UserDAO;
import edu.mum.wap.model.Result;
import edu.mum.wap.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

import static java.lang.Boolean.*;

@WebServlet({"/login", "/register", "/info"})
public class LoginController extends HttpServlet{
    private static final String LOGIN = "/login";
    private static final String REGISTER = "/register";
    private static final String INFO = "/info";
    private UserDAO dao;
    private ObjectMapper mapper;
    @Override
    public void init() throws ServletException {
        dao = new UserDAO();
        mapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getRequestURI();
        resp.setContentType("application/json;charset=UTF-8");
        String json = "";
        if(param.equals(INFO)) {
            String userNameInfo = (String)req.getSession().getAttribute("username");
            User userInfo = dao.getUserInfo(userNameInfo);
            req.setAttribute("uemail", userInfo.getUemail());
        }
        RequestDispatcher dis = req.getRequestDispatcher("/WEB-INF/jsp/info.jsp");
        dis.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getRequestURI();
        resp.setContentType("application/json;charset=UTF-8");
        String json = "";
        switch(param) {
            case LOGIN:
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
                break;
            case REGISTER:
                Result result;
                resp.setContentType("application/json;charset=UTF-8");
                String passReg = req.getParameter("upassword");
                String repass = req.getParameter("upasswordCheck");
                String nameReg = req.getParameter("uname");
                String email = req.getParameter("uemail");
                if(passReg.equals(repass)) {
                    User userReg = new User(nameReg, passReg, email);
                    result = dao.addUser(userReg);
                } else {
                    result = new Result(false, "Re-checked password is not matched");
                }
                json = mapper.writeValueAsString(result);
                break;
            default:
                break;
        }
        resp.getWriter().write(json);
    }
}
