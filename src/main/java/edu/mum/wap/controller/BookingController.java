package edu.mum.wap.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="booking", urlPatterns = "/booking")
public class BookingController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // get information from movie id, cinema id to render this page

        RequestDispatcher dis = req.getRequestDispatcher("/WEB-INF/jsp/booking.jsp");
        dis.forward(req, resp);
    }
}
