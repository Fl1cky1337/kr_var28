package org.example.kursach.controllers;

import java.io.*;


import jakarta.servlet.http.HttpSession;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.kursach.service.ControllLogin;
import org.example.kursach.service.DBconnection;
import org.example.kursach.service.NoteControl;
import org.example.kursach.service.User;

@WebServlet(name = "RegistrationServlet", value = "/registration-servlet")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redAlert;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        session.setAttribute("username", username);

        if (ControllLogin.addLogin(username,password)){
            request.setAttribute("notelist", NoteControl.selectUserNotes(DBconnection.connect(), User.getUsername()));
            request.getRequestDispatcher("profile.jsp").forward(request, response);

        }
        else {

            redAlert = "Login or password is incorrect";
            request.setAttribute("RedAlert", redAlert);
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }



    }
}