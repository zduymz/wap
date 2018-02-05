package edu.mum.wap.model;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cinema {
    private String id;
    private String address;
    private String name;
    private Map<ShowDate, Pair<Movie, Seat>> schedule = new HashMap<>();

    public Cinema(String id, String address, String name) {
        this.id = id;
        this.address = address;
        this.name = name;
    }

    public boolean hasMovie(Movie movie) {
        boolean ret = false;
        for(Pair<Movie, Seat> pair : schedule.values()) {
            if(pair.getKey().equals(movie)) {
                ret = true;
                break;
            }
        }
        return ret;
    }

    public void addSchedule(ShowDate time, Movie movie, Seat seat) {
        schedule.put(time, new Pair<>(movie, seat));
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }
}
