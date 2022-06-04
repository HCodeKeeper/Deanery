package com.hcodekeeper.deanery.listeners;

import com.hcodekeeper.deanery.configs.Config;
import com.hcodekeeper.deanery.configs.ConfigImpl;
import com.hcodekeeper.deanery.customExceptions.DatabaseURINotFound;
import com.hcodekeeper.deanery.helpers.DatabaseConnectionManager;
import com.hcodekeeper.deanery.helpers.MongoConnectionManager;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.File;

@WebListener
public class ContextListener implements ServletContextListener{

    public ContextListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        try{
            File configFile = new File("D:\\Github\\Deanery-main\\src\\main\\resources\\.env.local");
            Config config = new ConfigImpl(configFile);
            DatabaseConnectionManager dbConnection = new MongoConnectionManager(config);
            dbConnection.connect();

            context.setAttribute("databaseConnection", dbConnection);


        }catch (DatabaseURINotFound | IllegalArgumentException e){
            e.printStackTrace();
            context.setAttribute("databaseConnection", null);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        DatabaseConnectionManager dbConnectionManager = (DatabaseConnectionManager) context.getAttribute("databaseConnection");
        if(dbConnectionManager != null){
            dbConnectionManager.close();
        }
    }

    private void setupServices(ServletContext context){
        //
    }
}
