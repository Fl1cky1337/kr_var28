package org.example.kursach.service;

public class User {

    public static String username;
    private String password;

    public User(String login, String password) {

        this.username = login;
        this.password = password;
    }
    public User() {


    }
public static String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    public void setUsername(String login) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                " 'login='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
