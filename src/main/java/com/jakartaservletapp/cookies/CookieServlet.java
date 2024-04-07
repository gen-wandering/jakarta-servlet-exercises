package com.jakartaservletapp.cookies;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Arrays;

/*
 * Cookies
 * 1) Data, which is stored on client side and is used by a server.
 * 2) Server gets cookies from the "Cookie" header.
 *
 * Cookies path
 * 1) When client sends request to the server cookies header is formed.
 *    All relevant cookies are defined by the server domain (i.e. google.com),
 *    and servlet path (might be "/").
 * */

@WebServlet(name = "cookieServlet", value = "/cookie-servlet")
public class CookieServlet extends HttpServlet {
    private final String cookieName = "USER_ID";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        if (Arrays.stream(req.getCookies()).anyMatch(cookie -> cookie.getName().equals(cookieName))) {
            System.out.println("Saved value: " + Arrays.stream(req.getCookies())
                    .filter(cookie -> cookie.getName().equals(cookieName))
                    .findFirst()
                    .get()
                    .getValue());
        } else {
            Cookie cookie = new Cookie(cookieName, "1111test2222userid");

            // 2 minutes
            cookie.setMaxAge(60 * 2);
            cookie.setPath("/cookie-servlet");

            resp.addCookie(cookie);
        }
    }
}