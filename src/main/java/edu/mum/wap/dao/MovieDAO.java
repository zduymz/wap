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
                "Harry Porter",
                "/resources/media/movies/guardians-of-the-tombs/thumbnail.jpg",
                "/resources/media/movies/guardians-of-the-tombs/portrait.jpg",
                "5.8"));
        moviesDb.put("2", new Movie("2",
                "This is description",
                "1h42",
                "Harry Porter",
                "/resources/media/movies/guardians-of-the-tombs/thumbnail.jpg",
                "/resources/media/movies/guardians-of-the-tombs/portrait.jpg",
                "5.8"));
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
