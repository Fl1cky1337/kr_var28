package org.example.kursach.controllers;

import java.io.*;
import java.sql.SQLException;


import jakarta.servlet.http.HttpSession;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.kursach.service.ControlUser;
import org.example.kursach.service.DBconnection;

@WebServlet(name = "NewUserServlet", value = "/new-user-servlet")
public class NewUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redAlert;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            if (ControlUser.userExists(DBconnection.connect(),username)){

                redAlert = "Username is already taken";
                request.setAttribute("RedAlert", redAlert);
                request.getRequestDispatcher("regform.jsp").forward(request, response);

            }
            else {

                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                ControlUser.addUser(DBconnection.connect(),username,password);
                    response.sendRedirect("profile.jsp");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}