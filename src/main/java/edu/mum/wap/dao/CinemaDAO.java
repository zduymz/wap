package edu.mum.wap.dao;

import edu.mum.wap.model.Cinema;
import edu.mum.wap.model.Movie;
import edu.mum.wap.model.Seat;
import edu.mum.wap.model.ShowDate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CinemaDAO {
    private List<Cinema> cinemasDAO = new ArrayList<>();
    private MovieDAO movies = new MovieDAO();
    {
        Cinema c1 = new Cinema("1", "IO, 52557", "Galaxy1");
        Cinema c2 = new Cinema("2", "CO, 51234", "Galaxy2");
        c1.addSchedule(new ShowDate("2/14/2018", "Wed", "14:30"),
                movies.getMovieById("1"), new Seat());
        c1.addSchedule(new ShowDate("2/14/2018", "Wed", "16:30"),
                movies.getMovieById("1"), new Seat());
        c2.addSchedule(new ShowDate("2/14/2018", "Wed", "14:30"),
                movies.getMovieById("1"), new Seat());
        c2.addSchedule(new ShowDate("2/14/2018", "Wed", "16:30"),
                movies.getMovieById("1"), new Seat());
        cinemasDAO.add(c1);
        cinemasDAO.add(c2);
    }

    public List<Cinema> getCinemaList(Movie movie) {
        return cinemasDAO.stream().filter(cinema -> cinema.hasMovie(movie)).
                collect(Collectors.toList());
    }
}
