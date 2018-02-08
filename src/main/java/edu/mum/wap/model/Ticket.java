package edu.mum.wap.model;

public class Ticket {
    private int id = 0;
    private Movie movieobj;
    private String userId;
    private Cinema cinemaobj;
    private String timeShow;
    private String timeBook;
    private int numOfTicket;
    private String price;
    private String seats;

    public Ticket(Movie movieobj, String userId, Cinema cinemaobj,
                  String timeShow, String timeBook, String seat, String price) {
        this.movieobj = movieobj;
        this.userId = userId;
        this.cinemaobj = cinemaobj;
        this.timeShow = timeShow;
        //this.numOfTicket = numOfTicket;
        this.price = price;
        this.seats = seat;
        this.timeBook = timeBook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovieobj() {
        return movieobj;
    }

    public void setMovieobj(Movie movieobj) {
        this.movieobj = movieobj;
    }

    public Cinema getCinemaobj() {
        return cinemaobj;
    }

    public void setCinemaobj(Cinema cinemaobj) {
        this.cinemaobj = cinemaobj;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getNumOfTicket() {
        return numOfTicket;
    }

    public void setNumOfTicket(int numOfTicket) {
        this.numOfTicket = numOfTicket;
    }
}
