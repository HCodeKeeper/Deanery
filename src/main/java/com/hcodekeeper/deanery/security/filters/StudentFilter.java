package com.hcodekeeper.deanery.security.filters;

import com.hcodekeeper.deanery.models.identifiers.Role;
import com.hcodekeeper.deanery.helpers.RoleParser;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "StudentFilter", urlPatterns = "/student/*")
public class StudentFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        RoleParser roleParser = new RoleParser();
        Role role = roleParser.getRole(req);
        if(role == null || !role.equals(Role.STUDENT)){
            res.sendRedirect("/login");
        }
        else{
            chain.doFilter(request, response);
        }
    }
}
