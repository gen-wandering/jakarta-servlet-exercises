package com.jakartaservletapp.helloservlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;


    // Invoked when the servlet is created
    @Override
    public void init() {
        System.out.println("Servlet " + this.getClass().getSimpleName() + " is created");
        message = "Hello, World!";
    }

    /*
     * Method service() is invoked per each request.
     * This method redirects each request to the method
     * with corresponding name:
     *
     *    HTTP  |  HttpServlet
     *     GET --> doGet()
     *    POST --> doPost()
     *    ...
     * */

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    // Invoked when the servlet is deleted
    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getClass().getSimpleName() + " is destroyed");
    }
}