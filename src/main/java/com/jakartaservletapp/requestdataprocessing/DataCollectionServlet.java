package com.jakartaservletapp.requestdataprocessing;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "dataCollectionServlet", value = "/data-collection-servlet")
public class DataCollectionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();
        writer.println("<html><body><ul>");
        writer.println("<h1>" + "Entered data" + "</h1>");
        writer.println("<li>name: " + req.getParameter("name") + "</li>");
        writer.println("<li>email: " + req.getParameter("email") + "</li>");
        writer.println("<li>message: " + req.getParameter("message") + "</li>");
        writer.println("</ul></body></html>");
    }
}