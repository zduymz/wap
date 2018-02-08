package edu.mum.wap.dao;

import edu.mum.wap.model.Cinema;
import edu.mum.wap.model.Movie;
import edu.mum.wap.model.Seat;
import edu.mum.wap.model.ShowDate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CinemaDAO {
    private Map<String, Cinema> cinemasDAO = new HashMap<>();
    private MovieDAO movies = new MovieDAO();
    {

        Map<String, Integer[]> seat1 = new HashMap<>();
        seat1.put("A", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        seat1.put("B", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        seat1.put("C", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        seat1.put("D", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        seat1.put("E", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        seat1.put("F", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        seat1.put("G", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        seat1.put("H", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        seat1.put("I", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        seat1.put("J", new Integer[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});

        Seat seat = new Seat(seat1);
        Cinema c1 = new Cinema("1", "1215 Theatre Drive, Ottumwa, IA", "CEC - Ottumwa 8 Theatre");
        Cinema c2 = new Cinema("2", "831 Ave G, Fort Madison, IA", "Fox Theater - Fort Madison");
        Cinema c3 = new Cinema("3", "1602 Sycamore St, Iowa City, IA", "Marcus Sycamore Cinema");
        Cinema c4 = new Cinema("4", "550 S Gear Ave, West Burlington, IA", "CEC - Westland Mall 10");

        c1.addSchedule(new ShowDate("2/14/2018", "Wed", "14:30"),
                movies.getMovieById("1"), seat);
        c1.addSchedule(new ShowDate("2/14/2018", "Wed", "16:30"),
                movies.getMovieById("2"), seat);
        c1.addSchedule(new ShowDate("2/14/2018", "Wed", "18:30"),
                movies.getMovieById("3"), seat);
        c1.addSchedule(new ShowDate("2/14/2018", "Wed", "20:30"),
                movies.getMovieById("1"), seat);
        c1.addSchedule(new ShowDate("2/15/2018", "Thu", "8:00"),
                movies.getMovieById("2"), seat);
        c1.addSchedule(new ShowDate("2/15/2018", "Thu", "10:00"),
                movies.getMovieById("3"), seat);
        c1.addSchedule(new ShowDate("2/15/2018", "Thu", "12:00"),
                movies.getMovieById("1"), seat);
        c1.addSchedule(new ShowDate("2/15/2018", "Thu", "14:00"),
                movies.getMovieById("3"), seat);
        c1.addSchedule(new ShowDate("2/15/2018", "Thu", "16:00"),
                movies.getMovieById("4"), seat);
        c1.addSchedule(new ShowDate("2/15/2018", "Thu", "18:00"),
                movies.getMovieById("5"), seat);
        c1.addSchedule(new ShowDate("2/16/2018", "Fri", "8:00"),
                movies.getMovieById("1"), seat);
        c1.addSchedule(new ShowDate("2/16/2018", "Fri", "10:00"),
                movies.getMovieById("5"), seat);

        c2.addSchedule(new ShowDate("2/14/2018", "Wed", "17:30"),
                movies.getMovieById("1"), seat);
        c2.addSchedule(new ShowDate("2/14/2018", "Wed", "16:30"),
                movies.getMovieById("1"), seat);
        c3.addSchedule(new ShowDate("2/14/2018", "Wed", "18:30"),
                movies.getMovieById("1"), seat);
        c4.addSchedule(new ShowDate("2/14/2018", "Wed", "10:30"),
                movies.getMovieById("1"), seat);
        c2.addSchedule(new ShowDate("2/15/2018", "Wed", "14:30"),
                movies.getMovieById("2"), seat);
        c2.addSchedule(new ShowDate("2/15/2018", "Wed", "16:30"),
                movies.getMovieById("3"), seat);
        c3.addSchedule(new ShowDate("2/14/2018", "Wed", "14:30"),
                movies.getMovieById("2"), seat);
        c4.addSchedule(new ShowDate("2/14/2018", "Wed", "16:30"),
                movies.getMovieById("3"), seat);
        c4.addSchedule(new ShowDate("2/14/2018", "Wed", "18:30"),
                movies.getMovieById("6"), seat);
        c4.addSchedule(new ShowDate("2/14/2018", "Wed", "20:30"),
                movies.getMovieById("6"), seat);
        cinemasDAO.put("1",c1);
        cinemasDAO.put("2",c2);
        cinemasDAO.put("3",c3);
        cinemasDAO.put("4",c4);
    }

    public List<Cinema> getCinemaList(Movie movie) {
        return cinemasDAO.values().stream().filter(cinema -> cinema.hasMovie(movie))
                .collect(Collectors.toList());
    }

    public List<Cinema> getAllCinemas() {
        return cinemasDAO.values().stream().collect(Collectors.toList());
    }

    public Cinema getCinema(String id) {
        return cinemasDAO.get(id);
    }

    public List<ShowDate> getShowDate(String cinemaID, Movie movie) {
        return cinemasDAO.get(cinemaID).getShowDate(movie);
    }

    public Seat getSeat(String cinemaID, String time) {
        return cinemasDAO.get(cinemaID).getSeat(time);
    }

    public boolean updateSeat(String seat, String cinemaID, String time) {
        return cinemasDAO.get(cinemaID).getSeat(time).setSeat(seat);
    }
}
