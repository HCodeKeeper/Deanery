package com.hcodekeeper.deanery.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DBConnectionErrorServlet", value = "/login/perform_login/error/db_connection")
public class DBConnectionErrorServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("cause", "Connection with database was lost");
        request.getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if(session != null) {
            session.invalidate();
        }
        request.setAttribute("cause", "Connection with database was lost");

        request.getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
    }
}
