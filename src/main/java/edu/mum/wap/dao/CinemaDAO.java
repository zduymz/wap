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
        Cinema c1 = new Cinema("1", "1215 Theatre Drive, Ottumwa, IA 52501", "CEC - Ottumwa 8 Theatre");
        Cinema c2 = new Cinema("2", "831 Ave G, Fort Madison, IA 52627", "Fox Theater - Fort Madison");
        Cinema c3 = new Cinema("3", "1602 Sycamore St, Iowa City, IA 52240", "Marcus Sycamore Cinema");
        Cinema c4 = new Cinema("4", "550 S Gear Ave Suite #38, West Burlington, IA 52655\n", "CEC - Westland Mall 10");
        c1.addSchedule(new ShowDate("2/14/2018", "Wed", "14:30"),
                movies.getMovieById("1"), new Seat());
        c1.addSchedule(new ShowDate("2/14/2018", "Wed", "16:30"),
                movies.getMovieById("1"), new Seat());
        c2.addSchedule(new ShowDate("2/14/2018", "Wed", "14:30"),
                movies.getMovieById("1"), new Seat());
        c2.addSchedule(new ShowDate("2/14/2018", "Wed", "16:30"),
                movies.getMovieById("1"), new Seat());
        c3.addSchedule(new ShowDate("2/14/2018", "Wed", "14:30"),
                movies.getMovieById("1"), new Seat());
        c4.addSchedule(new ShowDate("2/14/2018", "Wed", "16:30"),
                movies.getMovieById("1"), new Seat());
        c2.addSchedule(new ShowDate("2/14/2018", "Wed", "14:30"),
                movies.getMovieById("2"), new Seat());
        c2.addSchedule(new ShowDate("2/14/2018", "Wed", "16:30"),
                movies.getMovieById("3"), new Seat());
        c3.addSchedule(new ShowDate("2/14/2018", "Wed", "14:30"),
                movies.getMovieById("2"), new Seat());
        c4.addSchedule(new ShowDate("2/14/2018", "Wed", "16:30"),
                movies.getMovieById("3"), new Seat());
        cinemasDAO.add(c1);
        cinemasDAO.add(c2);
        cinemasDAO.add(c3);
        cinemasDAO.add(c4);
    }

    public List<Cinema> getCinemaList(Movie movie) {
        return cinemasDAO.stream().filter(cinema -> cinema.hasMovie(movie)).
                collect(Collectors.toList());
    }
}
