package com.hcodekeeper.deanery.controllers;

import com.hcodekeeper.deanery.models.identifiers.Role;
import com.hcodekeeper.deanery.services.CreditService;
import com.hcodekeeper.deanery.services.impl.CreditServiceImp;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.hcodekeeper.deanery.helpers.ContextToDatabaseConnection;

import java.io.IOException;

@WebServlet(name = "LoginPerformerServlet", value = "/login/perform_login")
public class LoginPerformerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/login/perform_login/error");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("types");
        Role userRole = null;
        String roleEndpoint = null;
        if (role.equals("student")) {
            userRole = Role.STUDENT;
            roleEndpoint = "/student";
        } else if (role.equals("employee")) {
            userRole = Role.EMPLOYEE;
            roleEndpoint = "/employee";
        } else {
            request.setAttribute("cause", "The role you are trying to log in is currently not supported");
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
            return;
        }

        ContextToDatabaseConnection contextConn = new ContextToDatabaseConnection();
        ServletContext sce = request.getServletContext();

        if(contextConn.isConnectedToDB(sce)) {
            CreditService validator = (CreditService) sce.getAttribute("creditService");
            if (validator == null){
                response.sendRedirect("/login/perform_login/error/db_connection");
            }
            else {
                if (validator.isRegistered(username, password, userRole)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("role", userRole);
                    response.sendRedirect(roleEndpoint);
                } else {
                    response.sendRedirect("/login/perform_login/error/bad_credentials");
                }
            }
        }
        else {
            response.sendRedirect("/login/perform_login/error/db_connection");
        }
    }
}
