package com.jakartaservletapp.requestdataprocessing;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "pathVariableServlet", value = "/user/*")
public class PathVariableServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        var pathInfo = req.getPathInfo();
        var parameterNames = req.getParameterNames();

        var writer = resp.getWriter();

        if (pathInfo.equals("/")) {
            writer.println("Path variables: empty");
        } else {
            writer.println("Path variables: " +
                    Arrays.stream(pathInfo.split("/")).filter(s -> !s.isEmpty()).toList()
            );
        }

        if (!parameterNames.hasMoreElements()) {
            writer.println("Parameters: empty");
        } else {
            StringBuilder parameters = new StringBuilder("Parameters: ");

            while (parameterNames.hasMoreElements()) {
                String name = parameterNames.nextElement();
                parameters.append(name)
                        .append("=")
                        .append(req.getParameter(name))
                        .append(" ");
            }
            writer.println(parameters);
        }
    }
}