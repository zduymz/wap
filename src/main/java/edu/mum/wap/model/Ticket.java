package edu.mum.wap.model;

public class Ticket {
    private String movieId;
    private String userId;
    private String cinemaId;
    private String timeShow;
    private String timeBook;
    private int numOfTicket;
    private String seats;

    public Ticket(String movieId, String userId, String cinemaId,
                  String timeShow, String timeBook, String seat) {
        this.movieId = movieId;
        this.userId = userId;
        this.cinemaId = cinemaId;
        this.timeShow = timeShow;
        //this.numOfTicket = numOfTicket;
        this.seats = seat;
        this.timeBook = timeBook;
    }

    public String getTimeShow() {
        return timeShow;
    }

    public void setTimeShow(String timeShow) {
        this.timeShow = timeShow;
    }

    public String getTimeBook() {
        return timeBook;
    }

    public void setTimeBook(String timeBook) {
        this.timeBook = timeBook;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
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

    public int getNumOfTicket() {
        return numOfTicket;
    }

    public void setNumOfTicket(int numOfTicket) {
        this.numOfTicket = numOfTicket;
    }
}
