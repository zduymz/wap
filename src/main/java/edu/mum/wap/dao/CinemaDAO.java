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
        Cinema c1 = new Cinema("1", "IO, 52557", "Galaxy1");
        Cinema c2 = new Cinema("2", "CO, 51234", "Galaxy2");
        Integer[][] seat1 =
                        {{0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},{0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        };
        Seat seat = new Seat(seat1);
        c1.addSchedule(new ShowDate("2/14/2018", "Wed", "14:30"),
                movies.getMovieById("1"), seat);
        c1.addSchedule(new ShowDate("2/14/2018", "Wed", "16:30"),
                movies.getMovieById("1"), seat);
        c2.addSchedule(new ShowDate("2/14/2018", "Wed", "14:30"),
                movies.getMovieById("1"), seat);
        c2.addSchedule(new ShowDate("2/14/2018", "Wed", "16:30"),
                movies.getMovieById("1"), seat);
        cinemasDAO.put("1", c1);
        cinemasDAO.put("2", c2);
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
        //TODO: update seat status to DAO
        return true;
    }
}
