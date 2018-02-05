package edu.mum.wap.model;

public class Movie {
    private String id;
    private String description;
    private String duration;
    private String name;
    private String imageLandscape;
    private String imagePortrait;
    private String imdb;

    public Movie(String id, String description, String duration, String name, String imageLandscape, String imagePortrait, String imdb) {
        this.id = id;
        this.description = description;
        this.duration = duration;
        this.name = name;
        this.imageLandscape = imageLandscape;
        this.imagePortrait = imagePortrait;
        this.imdb = imdb;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageLandscape() {
        return imageLandscape;
    }

    public void setImageLandscape(String imageLandscape) {
        this.imageLandscape = imageLandscape;
    }

    public String getImagePortrait() {
        return imagePortrait;
    }

    public void setImagePortrait(String imagePortrait) {
        this.imagePortrait = imagePortrait;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }
}
