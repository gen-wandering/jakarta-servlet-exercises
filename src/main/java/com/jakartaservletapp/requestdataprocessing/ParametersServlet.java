package com.jakartaservletapp.requestdataprocessing;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "parametersServlet", value = "/parameter-servlet")
public class ParametersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String param = req.getParameter("id");

        System.out.println("Param: " + param);

        req.setAttribute("prevParam", param);

        RequestDispatcher dispatcher = req.getRequestDispatcher("param-res.jsp");
        dispatcher.forward(req, resp);
    }
}