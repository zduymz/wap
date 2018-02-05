package edu.mum.wap.model;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean verify(String pass) {
        return password.equals(pass);
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
