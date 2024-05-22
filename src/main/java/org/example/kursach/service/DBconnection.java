package org.example.kursach.service;

import java.sql.*;
import java.sql.DriverManager;


public class DBconnection {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection connect() {
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

}