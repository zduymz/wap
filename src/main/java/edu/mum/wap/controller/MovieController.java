package edu.mum.wap.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mum.wap.dao.CinemaDAO;
import edu.mum.wap.dao.MovieDAO;
import edu.mum.wap.model.Cinema;
import edu.mum.wap.model.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/movie/*")
public class MovieController extends HttpServlet {
    private static final String LIST = "list";
    private static final String MOVIE = "/movie/";
    private MovieDAO dao;
    private CinemaDAO cineDao;
    private ObjectMapper mapper;


    @Override
    public void init() throws ServletException {
        dao = new MovieDAO();
        cineDao = new CinemaDAO();
        mapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getRequestURI().replace(MOVIE, "");
        resp.setContentType("application/json;charset=UTF-8");
        String json = "";
        ObjectMapper mapper = new ObjectMapper();
        if(param.equals(LIST)) {
            List<Movie> list = dao.getAllMovies();
            try {
                json = mapper.writeValueAsString(list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        } else {
            Movie movie = dao.getMovieById(param);
            List<Cinema> list = cineDao.getCinemaList(movie);
            if(movie != null) {
                try {
                    json = mapper.writeValueAsString(list);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        resp.getWriter().write(json);
    }
}
