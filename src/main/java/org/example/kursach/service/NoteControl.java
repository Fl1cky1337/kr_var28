package org.example.kursach.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NoteControl {


    public static void addNote(Connection connection, String username,String heading, String maintext){
        String sql = "INSERT INTO notes (login, heading, maintext) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, heading);
            statement.setString(3, maintext);


            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("додана нотатка!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static String[][][] selectUserNotes(Connection connection, String login) {
        ArrayList<String[]> userNotesList = new ArrayList<>();
        String sql = "SELECT id, heading, maintext FROM Notes WHERE login = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, login);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String title = resultSet.getString("heading");
                    String content = resultSet.getString("maintext");
                    userNotesList.add(new String[]{id, title, content});
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String[][][] userNotesArray = new String[userNotesList.size()][1][3];
        for (int i = 0; i < userNotesList.size(); i++) {
            userNotesArray[i][0] = userNotesList.get(i);
        }

        return userNotesArray;
    }




    public static void deleteNote(Connection connection, String id){
        String sql = "DELETE FROM Notes WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            statement.executeUpdate();
            System.out.println("Запис з ID " + id + " успішно видалений.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String[][] findNote(Connection connection, String id) {
        String[][] noteData = null;
        String sql = "SELECT heading, maintext FROM Notes WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String title = resultSet.getString("heading");
                    String content = resultSet.getString("maintext");
                    noteData = new String[1][2];
                    noteData[0][0] = title;
                    noteData[0][1] = content;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return noteData;
    }


    public static void updateNote(Connection connection, String id, String newHeading, String newMaintext) {
        String sql = "UPDATE Notes SET heading = ?, maintext = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newHeading);
            statement.setString(2, newMaintext);
            statement.setString(3, id);
            statement.executeUpdate();
            System.out.println("Запис з ID " + id + " успішно змінений.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }











}
