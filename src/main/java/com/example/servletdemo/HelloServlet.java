package com.example.servletdemo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebServlet("/custom")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws  ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("<h1>Мій перший веб-застосунок на Java.</h2>");

    }
}
