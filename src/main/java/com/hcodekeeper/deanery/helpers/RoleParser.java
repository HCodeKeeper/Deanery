package com.hcodekeeper.deanery.helpers;

import com.hcodekeeper.deanery.models.identifiers.Role;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class RoleParser {
    private HttpServletRequest request;

    public RoleParser(HttpServletRequest request){
        this.request = request;
    }
    public Role getRole(){
        HttpSession session = request.getSession(false);
        if(session != null){
            Role credits = (Role) session.getAttribute("role");
            if(credits != null){
                return credits;
            }
        }
        return null;
    }
}
