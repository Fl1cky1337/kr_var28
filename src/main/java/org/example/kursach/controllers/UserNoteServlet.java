package org.example.kursach.controllers;

import java.io.*;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.kursach.service.DBconnection;
import org.example.kursach.service.NoteControl;

@WebServlet(name = "userNote", value = "/user-note")
public class UserNoteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String noteId = request.getParameter("noteID");
    String[][] noteInfo = NoteControl.findNote(DBconnection.connect(), noteId);
    System.out.println(noteInfo[0][0]);
    System.out.println(noteInfo[0][0]);
    System.out.println(noteId);
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>Note Creator</title></head><body style='background: #242433;'>");
    out.println("<h1 style='position:absolute;left:44%;top:18%;font-family:Lucida Console, Courier New, monospace; color: #e7e6e2;'>Note Creator</h1>");
    out.println("<div style='position:absolute;left:35%;top:30%;background-color: #e7e6e2;border-radius: 0%;width: 500px;border: 6px solid white;'>");
    out.println("<center><h1>User's note</h1></center>");
    out.println("<h2>Title:</h2>");
    out.println("<h3>"+noteInfo[0][0]+"</h3>");
    out.println("<h2>Text:</h2>");
    out.println("<h3>"+noteInfo[0][1]+"</h3>");
    out.println("<h6>Note Id:"+noteId+"</h6>");
    out.println("</div>");
    out.println("</body></html>");

    }


}




