package org.example.kursach.controllers;

import java.io.*;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.kursach.service.DBconnection;
import org.example.kursach.service.NoteControl;
import org.example.kursach.service.User;

@WebServlet(name = "NoteEditServlet", value = "/note-edit-servlet")
public class NoteEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String heading = request.getParameter("heading");
        String maintext = request.getParameter("maintext");
        String note = request.getParameter("noteID");
        NoteControl.updateNote(DBconnection.connect(),note,heading,maintext);
        request.setAttribute("notelist", NoteControl.selectUserNotes(DBconnection.connect(), User.getUsername()));
        request.getRequestDispatcher("profile.jsp").forward(request, response);


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String noteID = request.getParameter("noteID");
        String[][] noteData = NoteControl.findNote(DBconnection.connect(), noteID);
        request.setAttribute("noteData", noteData);
        request.setAttribute("noteID", noteID);
        request.getRequestDispatcher("editnote.jsp").forward(request, response);

        }
    }



