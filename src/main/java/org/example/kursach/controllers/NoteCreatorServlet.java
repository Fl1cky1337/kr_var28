package org.example.kursach.controllers;

import java.io.*;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.kursach.service.DBconnection;
import org.example.kursach.service.NoteControl;
import org.example.kursach.service.User;

@WebServlet(name = "NoteCreatorServlet", value = "/note-creator-servlet")
public class NoteCreatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String heading = request.getParameter("heading");
        String maintext = request.getParameter("maintext");
        NoteControl.addNote(DBconnection.connect(), User.getUsername(),heading,maintext);

        request.setAttribute("notelist", NoteControl.selectUserNotes(DBconnection.connect(), User.getUsername()));
        request.getRequestDispatcher("profile.jsp").forward(request, response);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String noteID = request.getParameter("noteID");


        NoteControl.deleteNote(DBconnection.connect(), noteID);
        String[][][] updatedNoteList = NoteControl.selectUserNotes(DBconnection.connect(), User.getUsername());
        request.setAttribute("notelist", updatedNoteList);
        request.getRequestDispatcher("profile.jsp").forward(request, response);}


    }



