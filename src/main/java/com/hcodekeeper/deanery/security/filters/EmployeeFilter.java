package com.hcodekeeper.deanery.security.filters;

import com.hcodekeeper.deanery.models.identifiers.Role;
import com.hcodekeeper.deanery.helpers.RoleParser;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "EmployeeFilter", urlPatterns = "/employee/*")
public class EmployeeFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        RoleParser roleParser = new RoleParser(req);
        Role role = roleParser.getRole();
        if(role == null){
            res.sendRedirect("/login");
        }
        else if(role == Role.EMPLOYEE){
            res.sendRedirect(req.getContextPath());
        }
        else{
            chain.doFilter(request, response);
        }
    }
}
