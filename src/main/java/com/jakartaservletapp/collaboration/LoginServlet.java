package com.jakartaservletapp.collaboration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        var name = req.getParameter("name");
        var password = req.getParameter("password");

        if (password.equals("myPass")) {
            req.setAttribute("userName", name);

            RequestDispatcher dispatcher = req.getRequestDispatcher("collaboration/welcome.jsp");
            dispatcher.forward(req, resp);
        } else {
            PrintWriter writer = resp.getWriter();
            writer.println("<p class=\"center\">" + "Some bad looking notification about your password mismatch!" + "</p>");

            RequestDispatcher dispatcher = req.getRequestDispatcher("collaboration/registration.html");
            dispatcher.include(req, resp);
        }
    }
}
