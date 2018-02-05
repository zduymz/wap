package edu.mum.wap.model;

import java.util.Date;
import java.util.Timer;

public class Ticket {
    private String movieId;
    private String userId;
    private String cinemaId;
    private Date time;
    private int numOfTicket;

    public Ticket(String movieId, String userId, String cinemaId, Date time, int numOfTicket) {
        this.movieId = movieId;
        this.userId = userId;
        this.cinemaId = cinemaId;
        this.time = time;
        this.numOfTicket = numOfTicket;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(String cinemaId) {
        this.cinemaId = cinemaId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getNumOfTicket() {
        return numOfTicket;
    }

    public void setNumOfTicket(int numOfTicket) {
        this.numOfTicket = numOfTicket;
    }
}
