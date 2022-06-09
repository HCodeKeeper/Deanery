package com.hcodekeeper.deanery.controllers.employee.update;

import com.hcodekeeper.deanery.customExceptions.RecordDoesntExist;
import com.hcodekeeper.deanery.services.StudentService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "StudentDeletePerformerServlet", value = "/employee/delete/student/perform_deletion")
public class StudentDeletePerformerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("prevName");
        if(!name.isEmpty()) {
            StudentService studentService = (StudentService) request
                    .getServletContext()
                    .getAttribute("studentService");
            try {
                studentService.delete(name);
            } catch (RecordDoesntExist e){
                request.setAttribute("cause", e.getMessage());
                request.setAttribute("returnPage", "/employee");
                request.getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
            }
        }
        response.sendRedirect("/employee");
    }
}
