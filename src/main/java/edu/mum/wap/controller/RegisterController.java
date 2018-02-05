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
        User user = new User(req.getParameter("uname"),req.getParameter("upassword")) ;
        resp.setContentType("application/json;charset=UTF-8");
        Result result = dao.addUser(user);
        String json = mapper.writeValueAsString(result);
        resp.getWriter().write(json);
    }
}
