package com.jakartaservletapp.configurableservlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "configurableServlet", urlPatterns = "/config-servlet")
public class ConfigurableServlet extends HttpServlet {

    private ServletContext servletContext;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.servletContext = config.getServletContext();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");

        writer.println("<p>ServletContext welcomeMessage: "
                + servletContext.getInitParameter("welcomeMessage")
                + "</p>"
        );
        writer.println("<p>" + "ServletContext adminEmail: "
                + servletContext.getInitParameter("adminEmail")
                + "</p>"
        );
    }
}
