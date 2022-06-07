package com.hcodekeeper.deanery.controllers;

import com.hcodekeeper.deanery.customExceptions.RecordDoesntExist;
import com.hcodekeeper.deanery.models.identifiers.Role;
import com.hcodekeeper.deanery.services.CreditService;
import com.hcodekeeper.deanery.services.EmployeeService;
import com.hcodekeeper.deanery.services.StudentService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "InsertDataServlet", value = "/InsertDataServlet")
public class InsertDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*EmployeeService employeeService = (EmployeeService) request.getServletContext().getAttribute("employeeService");
        try{
            employeeService.add("SUPER_ADMIN", "admin", "super");
        } catch (RecordDoesntExist e){
            System.out.println(e.getMessage());
        }
         */
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
