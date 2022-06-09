package com.hcodekeeper.deanery.controllers.employee.update;

import com.hcodekeeper.deanery.customExceptions.RecordDoesntExist;
import com.hcodekeeper.deanery.services.StudentService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "StudentUpdatePerformerServlet", value = "/employee/update/student/perform_update")
public class StudentUpdatePerformerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("studentName");
        if (name.isEmpty() || name == null){
            request.setAttribute("cause", "Can't change student's name with empty field");
            request.getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
        else {
            StudentService studentService = (StudentService) request
                    .getServletContext()
                    .getAttribute("studentService");
            try{
                String prevName = request.getParameter("prevName");
                studentService.changeName(prevName, name);
                response.sendRedirect("/employee");
            } catch (RecordDoesntExist e){
                request.setAttribute("cause", e.getMessage());
                request.setAttribute("returnPage", "/employee");
                request.getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
            }
        }

    }
}
