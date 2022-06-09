package com.hcodekeeper.deanery.controllers.employee.update;

import com.hcodekeeper.deanery.models.Student;
import com.hcodekeeper.deanery.services.StudentService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "StudentUpdaterServlet", value = "/employee/update/student")
public class StudentUpdaterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentService studentService = (StudentService)request.getServletContext().getAttribute("studentService");
        Student student = studentService.get(request.getParameter("studentName"));
        request.setAttribute("student", student);
        request.getRequestDispatcher("/WEB-INF/employee/student.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
