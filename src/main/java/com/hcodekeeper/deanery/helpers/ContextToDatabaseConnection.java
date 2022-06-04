package com.hcodekeeper.deanery.helpers;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;

public class ContextToDatabaseConnection {
    public boolean isConnectedToDB(ServletContext context){
        if(context.getAttribute("databaseConnection") != null){
            return true;
        }
        return false;
    }
}
