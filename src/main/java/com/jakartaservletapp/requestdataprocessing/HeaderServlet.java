package com.jakartaservletapp.requestdataprocessing;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "headerServlet", value = "/header-servlet")
public class HeaderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String tokenHeader = "authentication-token";
        String tokenMetaInfHeader = "Token-Meta-Inf";

        var token = req.getHeader(tokenHeader);
        var inf = req.getHeader(tokenMetaInfHeader);
        PrintWriter writer = resp.getWriter();

        if (token != null && inf != null) {
            System.out.println(req.getHeader("Token: " + tokenHeader));
            System.out.println(req.getHeader("Inf message: " + tokenMetaInfHeader));

            writer.println("Authentication token and meta-inf received!");
        } else {
            writer.println("Some headers are missing!");
        }
    }
}
