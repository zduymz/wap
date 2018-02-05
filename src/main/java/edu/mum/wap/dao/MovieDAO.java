package edu.mum.wap.dao;

import edu.mum.wap.model.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieDAO {
    Map<String, Movie> moviesDb = new HashMap<String, Movie>();

    {
        moviesDb.put("1", new Movie("1",
                "This is description",
                "1h42",
                "Guardians of the Tombs",
                "/resources/media/movies/guardians-of-the-tombs/thumbnail.jpg",
                "/resources/media/movies/guardians-of-the-tombs/portrait.jpg",
                "5.8"));
        moviesDb.put("2", new Movie("2",
                "This is description",
                "2h12",
                "Maze Runner The Death Cure",
                "/resources/media/movies/maze-runner-the-death-cure/thumbnail.jpg",
                "/resources/media/movies/maze-runner-the-death-cure/portrait.jpg",
                "6.9"));
        moviesDb.put("3", new Movie("3",
                "This is description",
                "1h58",
                "Paddington 2",
                "/resources/media/movies/paddington-2/thumbnail.jpg",
                "/resources/media/movies/paddington-2/portrait.jpg",
                "6.5"));
        moviesDb.put("4", new Movie("4",
                "This is description",
                "2h05",
                "The Commuter",
                "/resources/media/movies/the-commuter/thumbnail.jpg",
                "/resources/media/movies/the-commuter/portrait.jpg",
                "6.5"));
        moviesDb.put("5", new Movie("5",
                "This is description",
                "2h30",
                "The Greatest Showman",
                "/resources/media/movies/the-greatest-showman/thumbnail.jpg",
                "/resources/media/movies/the-greatest-showman/portrait.jpg",
                "7.6"));
        moviesDb.put("6", new Movie("6",
                "This is description",
                "2h00",
                "The Shape of Water",
                "/resources/media/movies/the-shape-of-water/thumbnail.jpg",
                "/resources/media/movies/the-shape-of-water/portrait.jpg",
                "7.8"));
    }

    public void addMovie(Movie movie){
        moviesDb.put(genId(), movie);
    }

    public void deleteMovie(int MovieId){
        moviesDb.remove(MovieId);
    }

    public void updateMovie(Movie Movie){
       // moviesDb.put(Movie.getId(), Movie);
    }

    public List<Movie> getAllMovies(){
        return new ArrayList<Movie>(moviesDb.values());
    }

    public Movie getMovieById(String id){
        return moviesDb.get(id);
    }

    public String genId() {
        return Integer.toString(moviesDb.size()+1);
    }
}
