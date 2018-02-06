package edu.mum.wap.model;

import java.util.HashMap;
import java.util.Map;

public class Seat {
    //private Integer[][] seats = new Integer[10][10];
    private Map<String, Integer[]> seats = new HashMap<>();

    public Seat(Map<String, Integer[]> seats) {
        this.seats = seats;
    }

    public Map<String, Integer[]> getSeats() {
        return seats;
    }

    public void setSeats(Map<String, Integer[]> seats) {
        this.seats = seats;
    }
}
