package org.example.kursach.service;


import java.sql.SQLException;

public class ControllLogin {
    public static boolean addLogin(String login, String password) {
        try {
            if(ControlUser.checkPassword(DBconnection.connect(), login, password)){
                User user = new User(login, password);
                user.setUsername(login);
                user.setPassword(password);
                return true;
            }else {
                return false;

            }
         } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}