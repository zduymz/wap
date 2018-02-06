package edu.mum.wap.model;

public class Seat {
    private Integer[][] seats = new Integer[10][10];

    public Seat(Integer[][] seats) {
        this.seats = seats;
    }

    public Integer[][] getSeats() {
        return seats;
    }

    public void setSeats(Integer[][] seats) {
        this.seats = seats;
    }
}
