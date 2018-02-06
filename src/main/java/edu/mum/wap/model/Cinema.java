package edu.mum.wap.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cinema {
    private String id;
    private String address;
    private String name;
    @JsonIgnore
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

    public Map<ShowDate, Pair<Movie, Seat>> getSchedule() {
        return schedule;
    }

    public List<ShowDate> getShowDate(Movie movie) {
        return schedule.keySet()
                .stream()
                .filter(n -> schedule.get(n).getKey().equals(movie))
                .collect(Collectors.toList());
    }

    public Seat getSeat(String date) {
        ShowDate time = new ShowDate(date);
        Pair<Movie, Seat> pair = schedule.get(time);
        return pair.getValue();
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
