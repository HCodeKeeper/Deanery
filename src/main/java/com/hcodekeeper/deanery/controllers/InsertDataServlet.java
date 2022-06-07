package com.hcodekeeper.deanery.controllers;

import com.hcodekeeper.deanery.customExceptions.RecordAlreadyExists;
import com.hcodekeeper.deanery.customExceptions.RecordDoesntExist;
import com.hcodekeeper.deanery.models.identifiers.Role;
import com.hcodekeeper.deanery.services.CreditService;
import com.hcodekeeper.deanery.services.EmployeeService;
import com.hcodekeeper.deanery.services.GroupService;
import com.hcodekeeper.deanery.services.StudentService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "InsertDataServlet", value = "/InsertDataServlet")
public class InsertDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GroupService employeeService = (GroupService) request.getServletContext().getAttribute("groupService");
        StudentService studentService = (StudentService) request.getServletContext().getAttribute("studentService");
        try{
            studentService.add("user", "1234", "The Man");
            employeeService.add("IA-11");
            employeeService.addStudent("IA-11", "The Man");
        } catch (RecordAlreadyExists | RecordDoesntExist e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
