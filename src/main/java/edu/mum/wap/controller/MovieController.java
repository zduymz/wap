package edu.mum.wap.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mum.wap.dao.CinemaDAO;
import edu.mum.wap.dao.MovieDAO;
import edu.mum.wap.dao.TicketDAO;
import edu.mum.wap.model.*;
import javafx.util.Pair;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.*;

@WebServlet({"/movie/list", "/cinema/*", "/showtime/*", "/seat/*", "/confirmation/*"})
public class MovieController extends HttpServlet {
    private static final String LIST = "list";
    private static final String MOVIE = "movie";
    private static final String CINE = "cinema";
    private static final String SEAT = "seat";
    private static final String SHOWTIME = "showtime";
    private static final String CONFIRM = "confirmation";
    private MovieDAO dao;
    private CinemaDAO cineDao;
    private ObjectMapper mapper;
    private TicketDAO ticketDAO;


    @Override
    public void init() throws ServletException {
        dao = new MovieDAO();
        cineDao = new CinemaDAO();
        mapper = new ObjectMapper();
        ticketDAO = new TicketDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI();
        Scanner scanner = new Scanner(path);
        String reqType = scanner.useDelimiter("/").next();
        String param = path.replace("/"+reqType+"/","");

        resp.setContentType("application/json;charset=UTF-8");
        String json = "";
        ObjectMapper mapper = new ObjectMapper();

        switch (reqType) {
            case MOVIE:
                if(param.equals(LIST)) { // /api/movie/list
                    List<Movie> list = dao.getAllMovies();
                    try {
                        json = mapper.writeValueAsString(list);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case CINE:
                if(param.equals(LIST)) {// /api/cinema/list
                    List<Cinema> list = cineDao.getAllCinemas();
                    try {
                        json = mapper.writeValueAsString(list);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                } else {// /api/cinema/movieid=<movie_id>
                    Movie movie = dao.getMovieById(param.replace("movieid=", ""));
                    if (movie != null) {
                        try {
                            HttpSession session = req.getSession();
                            session.setAttribute("movie", movie);
                            List<Cinema> list = cineDao.getCinemaList(movie);
                            json = mapper.writeValueAsString(list);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
            case SHOWTIME: // /api/showtime/movieid=<movie_id>,cinemaid=<cinema_id>
                Scanner scannerShowTime = new Scanner(param);
                String movieIdShowTime = scannerShowTime.useDelimiter(",")
                        .next().replace("movieid=","");
                String cineId = scannerShowTime.useDelimiter(",")
                        .next().replace("cinemaid=", "");
                Movie movie = dao.getMovieById(movieIdShowTime);
                if(movie == null) {
                    break;
                }
                List<ShowDate> list = cineDao.getShowDate(cineId, movie);
                Map<String, Show> listShow = new HashMap<>();
                for(ShowDate date : list) {
                    if(listShow.isEmpty()) {
                        Show show = new Show(date.getShowDate(), date.getDayOfWeekLabel());
                        show.addTime(date.getShowTime());
                        listShow.put(date.getShowDate(), show);
                    } else {
                        Show show = listShow.get(date.getShowDate());
                        if(show == null) {
                            listShow.put(date.getShowDate(), new Show(date));
                        } else {
                            show.addTime(date.getShowTime());
                        }
                    }
                }
                try {
                    json = mapper.writeValueAsString(listShow.values());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case SEAT: // /api/seat/cinemaid=<cinema_id>,showtime=EEE_mm/dd/yyyy_HH:mm
                Scanner scannerSeat = new Scanner(param);
                String cineIdSeat = scannerSeat.useDelimiter(",")
                        .next().replace("cinemaid=", "");
                String time = scannerSeat.useDelimiter(",")
                        .next().replace("showtime=","");
                Seat seat = cineDao.getSeat(cineIdSeat, time);
                if(seat != null) {
                    try {
                        json = mapper.writeValueAsString(seat);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case CONFIRM: // /api/confirmation/movieid=<movie_id>,cinemaid=<cinema_id>,showtime=EEE_mm/dd/yyyy_HH:mm,seats=A1_A2
                Scanner scannerConfirmation = new Scanner(param);
                String movieIdConfirm = scannerConfirmation.useDelimiter(",")
                        .next().replace("movieid", "");
                String cineIdConfirm = scannerConfirmation.useDelimiter(",")
                        .next().replace("cinemaid=", "");
                String timeConfirm = scannerConfirmation.useDelimiter(",")
                        .next().replace("showtime=","");
                String seats = scannerConfirmation.useDelimiter(",")
                        .next().replace("seats=","");
                String now = ZonedDateTime.now().toString();
                try {
                    if(cineDao.updateSeat(seats, cineIdConfirm, timeConfirm)) {
                        HttpSession session = req.getSession();
                        User user = (User)session.getAttribute("user");
                        Ticket ticket = new Ticket(movieIdConfirm, user.getUsername(),
                                cineIdConfirm, timeConfirm, now, seats);
                        ticketDAO.addTicket(ticket);
                        json = mapper.writeValueAsString(ticket);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
        resp.getWriter().write(json);
    }
}
