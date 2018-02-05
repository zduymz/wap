package edu.mum.wap.controller;

import edu.mum.wap.dao.UserDAO;
import edu.mum.wap.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet{
    private UserDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(req.getParameter("user"),req.getParameter("pass")) ;
        if(dao.verifyUser(user)) {

        } else {
            resp.sendRedirect("login.jsp");
        }
    }
}
