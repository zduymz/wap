package edu.mum.wap.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Seat {
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

    public boolean setSeat(String seats) { // Seat format <ROW_COL, ROW_COL, ...>: A1, A2
        boolean ret = true;
        try {
            String s = seats.replace(" ", "");
            String[] array = s.split(",");
            for (String a : array) {
                String row = a.substring(0, 1);
                String col = a.substring(1);
                Integer[] irow = this.seats.get(row);
                irow[Integer.valueOf(col) - 1] = 1;
                this.seats.put(row, irow);
            }
        } catch(Exception e) {
            ret = false;
        }
        return ret;
    }
}
