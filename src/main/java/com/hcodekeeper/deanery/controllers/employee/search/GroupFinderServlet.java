package com.hcodekeeper.deanery.controllers.employee.search;

import com.hcodekeeper.deanery.customExceptions.RecordDoesntExist;
import com.hcodekeeper.deanery.models.Group;
import com.hcodekeeper.deanery.services.GroupService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "GroupFinderServlet", value = "/employee/find/group")
public class GroupFinderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HashMap<String, String[]> parameters = new HashMap<>(request.getParameterMap());
       GroupService groupService = (GroupService) request.getServletContext().getAttribute("groupService");

       try {
           if (parameters.get("parameter")[0].equals("groupName")) {
               Group group = groupService.getByName(parameters.get("query")[0]);
               request.setAttribute("group", group);
               request.getRequestDispatcher("WEB-INF/employee/group.jsp").forward(request, response);
           } else if (parameters.get("parameter")[0].equals("studentName")) {
               Group group = groupService.getByStudentName(parameters.get("query")[0]);
               request.setAttribute("group", group);
               request.getRequestDispatcher("WEB-INF/employee/group.jsp").forward(request, response);
           }
       } catch (RecordDoesntExist e){
           request.setAttribute("cause", e.getMessage());
           request.getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
       }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
