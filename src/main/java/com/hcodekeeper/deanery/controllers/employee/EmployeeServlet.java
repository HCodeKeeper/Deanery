package com.hcodekeeper.deanery.controllers.employee;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EmployeeServlet", value = "/employee")
public class EmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userFunction = "List all students";
        String links = "/employee/list/students";
        request.setAttribute("userFunction", userFunction);
        request.setAttribute("functionLink", links);

        request.getRequestDispatcher("/WEB-INF/employee/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
