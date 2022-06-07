package com.hcodekeeper.deanery.helpers;

import com.hcodekeeper.deanery.models.identifiers.Role;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class RoleParser {
    public Role getRole(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session != null){
            Role credits = (Role) session.getAttribute("role");
            if(credits != null){
                return credits;
            }
        }
        return null;
    }

    public void eraseRole(HttpServletRequest request){
        if (getRole(request) != null){
            request.getSession().setAttribute("role", null);
        }
    }
}
