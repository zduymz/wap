package edu.mum.wap.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mum.wap.dao.CinemaDAO;
import edu.mum.wap.dao.MovieDAO;
import edu.mum.wap.dao.PriceDAO;
import edu.mum.wap.dao.TicketDAO;
import edu.mum.wap.model.*;
import javafx.util.Pair;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.*;

@WebServlet({"/movie/list", "/cinema/*", "/showtime/*", "/booking", "/confirmation", "/ticketinfo"})
public class MovieController extends HttpServlet {
    private static final String LIST = "list";
    private static final String MOVIE = "movie";
    private static final String CINE = "cinema";
    private static final String BOOKING = "booking";
    private static final String SHOWTIME = "showtime";
    private static final String CONFIRM = "confirmation";
    private static final String INFO = "ticketinfo";
    private MovieDAO dao;
    private CinemaDAO cineDao;
    private ObjectMapper mapper;
    private TicketDAO ticketDAO;
    private PriceDAO priceDAO;


    @Override
    public void init() throws ServletException {
        dao = new MovieDAO();
        cineDao = new CinemaDAO();
        mapper = new ObjectMapper();
        ticketDAO = new TicketDAO();
        priceDAO = new PriceDAO();
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
                    String _date = date.getShowDate();
                    String _time = date.getShowTime();
                    if(listShow.isEmpty()) {
                        Show show = new Show(_date, date.getDayOfWeekLabel());
                        show.addTime(_time);
                        listShow.put(_date, show);
                    } else {
                        Show show = listShow.get(_date);
                        if(show == null) {
                            Show _show = new Show(date);
                            listShow.put(_date, _show);
                        } else {
                            show.addTime(_time);
                        }
                    }
                }
                try {
                    json = mapper.writeValueAsString(listShow.values());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case INFO:
                String userNameInfo = (String)req.getSession().getAttribute("username");
                List<Ticket> ticketList = ticketDAO.getTicketByUserId(userNameInfo);
                try {
                    json = mapper.writeValueAsString(ticketList);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            default:
                break;
        }
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI();
        Scanner scanner = new Scanner(path);
        String reqType = scanner.useDelimiter("/").next();
        String param = path.replace("/"+reqType+"/","");

        resp.setContentType("application/json;charset=UTF-8");
        String json = "";
        ObjectMapper mapper = new ObjectMapper();

        switch (reqType) {
            case BOOKING:
                Scanner scannerSeat = new Scanner(param);
                String cineIdSeat = req.getParameter("cinema_id");
                String movieId = req.getParameter("movie_id");
                String time = req.getParameter("time_id");
                String noTicket = req.getParameter("noticket_id");
                Seat seat = cineDao.getSeat(cineIdSeat, time);
                if (seat != null) {
                    try {
                        json = mapper.writeValueAsString(seat);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                req.setAttribute("noticket_id", noTicket);
                req.setAttribute("seat_map", seat);
                req.setAttribute("time_id", time);
                req.setAttribute("movie_obj", dao.getMovieById(movieId));
                req.setAttribute("cinema_obj", cineDao.getCinema(cineIdSeat));
                req.setAttribute("price", priceDAO.getPrice("adult"));
                RequestDispatcher dis = req.getRequestDispatcher("/WEB-INF/jsp/booking.jsp");
                dis.forward(req, resp);
                break;
            case CONFIRM:
                Scanner scannerConfirmation = new Scanner(param);
                Movie movieObject = dao.getMovieById(req.getParameter("movie_id"));
                String cineIdConfirm = req.getParameter("cinema_id");
                Cinema cinemaObject = cineDao.getCinema(cineIdConfirm);
                String timeConfirm = req.getParameter("time_id");
                String seats = req.getParameter("noTicket_id");
                String ticketprice = req.getParameter("ticketPrice_id");
                String now = ZonedDateTime.now().toString();
                try {
                    if(cineDao.updateSeat(seats, cineIdConfirm, timeConfirm)) {
                        HttpSession session = req.getSession();
                        String user = (String)session.getAttribute("username");
                        Ticket ticket = new Ticket(movieObject, user,
                                cinemaObject, timeConfirm, now, seats, ticketprice);
                        int ticketId = ticketDAO.addTicket(ticket);
                        req.setAttribute("ticket_id", ticketId);
                        req.setAttribute("seat", seats);
                        req.setAttribute("time_id", timeConfirm);
                        req.setAttribute("book_time", now);
                        req.setAttribute("movie_obj", movieObject);
                        req.setAttribute("cinema_obj", cinemaObject);
                        req.setAttribute("price", ticketprice);
                        RequestDispatcher confirm = req.getRequestDispatcher("/WEB-INF/jsp/cofirmation.jsp");
                        confirm.forward(req, resp);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }
}
