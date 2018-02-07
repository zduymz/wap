package edu.mum.wap.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name="index", urlPatterns = "/index")
public class IndexController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        for(Cookie c : req.getCookies()) {
            if (c.getName().equals("login_id")) {
                req.setAttribute("username", c.getValue());
            }
        }

        RequestDispatcher dis = req.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
        dis.forward(req, resp);
    }
}
