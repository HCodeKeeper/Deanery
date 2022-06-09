package com.hcodekeeper.deanery.controllers.employee.search;

import com.hcodekeeper.deanery.customExceptions.RecordDoesntExist;
import com.hcodekeeper.deanery.models.Group;
import com.hcodekeeper.deanery.models.Student;
import com.hcodekeeper.deanery.services.GroupService;
import com.hcodekeeper.deanery.services.StudentService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.bson.types.ObjectId;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "GroupFinderServlet", value = "/employee/find/group")
public class GroupFinderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HashMap<String, String[]> parameters = new HashMap<>(request.getParameterMap());
       GroupService groupService = (GroupService) request.getServletContext().getAttribute("groupService");
       StudentService studentService = (StudentService) request.getServletContext().getAttribute("studentService");

       try {
           if (parameters.get("parameter")[0].equals("groupName")) {
               Group group = groupService.getByName(parameters.get("query")[0]);
               request.setAttribute("group", group);
               List<Student> students = new ArrayList();
               try {
                   for (ObjectId id : group.getStudentIds()) {
                       students.add(studentService.get(id));
                   }
               } catch (RecordDoesntExist e){
                   
               }
               request.setAttribute("students", students);
               request.getRequestDispatcher("/WEB-INF/employee/group.jsp").forward(request, response);
           } else if (parameters.get("parameter")[0].equals("studentName")) {
               Group group = groupService.getByStudentName(parameters.get("query")[0]);
               request.setAttribute("group", group);
               List<Student> students = new ArrayList();
               for (ObjectId id : group.getStudentIds()){
                   students.add(studentService.get(id));
               }
               request.setAttribute("students", students);
               request.getRequestDispatcher("/WEB-INF/employee/group.jsp").forward(request, response);
           }
       } catch (RecordDoesntExist e){
           request.setAttribute("cause", e.getMessage());
           request.setAttribute("returnPage", "/employee");
           request.getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
       }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
