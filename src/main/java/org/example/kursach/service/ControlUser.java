package org.example.kursach.service;

import java.sql.*;

public class ControlUser {

public static void addUser(Connection connection, String username, String password) throws SQLException {
        String sql = "INSERT INTO users (login, password) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }

 public static boolean checkPassword(Connection connection, String username, String password) throws SQLException {
        String sql = "SELECT COUNT(*) AS count FROM users WHERE login = ? AND password = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt("count");
                    if (count > 0) {
                        System.out.println("Пароль вірний");
                        return true;
                    } else {
                        System.out.println("Пароль невірний");
                        return false;
                    }
                }
            }
        }
        return false;
    }



    public static boolean userExists(Connection connection, String username) throws SQLException {
        String sql = "SELECT COUNT(*) AS count FROM users WHERE login = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt("count");
                    if (count > 0) {
                        System.out.println("Користувач існує");
                        return true;
                    } else {
                        System.out.println("Користувача не існує");
                        return false;
                    }
                }
            }
        }
        return false;
    }





    public static void deleteUser(Connection connection, String username) throws SQLException {
        String sql = "DELETE FROM users WHERE login = '" + username + "'";

        Statement statement = connection.createStatement();

        int rowsAffected = statement.executeUpdate(sql);

        if (rowsAffected > 0) {
            System.out.println("Пользователь успешно удален");
        } else {
            System.out.println("Пользователь не найден");
        }
    }




}




