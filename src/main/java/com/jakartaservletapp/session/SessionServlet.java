package com.jakartaservletapp.session;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.Arrays;

/*
 * Session
 * 1) A set of combined requests.
 * 2) Session workflow in Tomcat is represented by cookie JSESSIONID
 *    and session id.
 * 3) All active sessions are stored in Map<String, Session> sessions
 *    on the server.
 *
 * JSESSIONID
 * 1) Unique session identifier (is created upon the first server request)
 * 2) To identify if the session is the same for the user JSESSIONID cookie
 *    value is compared with session id, if they are equal, than the session
 *    is the same.
 *
 * Session attributes
 * 1) Some data can be shared between several request form the same user by
 *    specifying session attributes (represented by Map<String, Object>).
 *
 * Available levels of data sharing between servlets: parameter-availability-levels.PNG
 * */

@WebServlet(name = "sessionServlet", value = "/session-servlet")
public class SessionServlet extends HttpServlet {
    private final String ATTR_NAME = "counter";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        HttpSession session = req.getSession();

        System.out.print("Session id: " + session.getId() +
                         "\nJSESSIONID: ");
        System.out.println(Arrays.stream(req.getCookies())
                .filter(cookie -> cookie.getName().equals("JSESSIONID"))
                .findFirst().orElse(null)
                .getValue()
        );
        System.out.println("Is session new: " + session.isNew());

        if (session.isNew()) {
            session.setAttribute(ATTR_NAME, 1);
        } else {
            int counter = (int) session.getAttribute(ATTR_NAME);

            session.setAttribute(ATTR_NAME, ++counter);
            System.out.println("Amount of requests per user: " + counter);

            if (counter >= 3) session.invalidate();
        }
    }
}