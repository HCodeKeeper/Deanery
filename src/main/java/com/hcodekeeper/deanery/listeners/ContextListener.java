package com.hcodekeeper.deanery.listeners;

import com.hcodekeeper.deanery.configs.Config;
import com.hcodekeeper.deanery.configs.ConfigImpl;
import com.hcodekeeper.deanery.customExceptions.DatabaseURINotFound;
import com.hcodekeeper.deanery.dao.DaoFactory;
import com.hcodekeeper.deanery.dao.impl.mongo.MongoDaoFactory;
import com.hcodekeeper.deanery.helpers.DatabaseConnectionManager;
import com.hcodekeeper.deanery.helpers.MongoConnectionManager;
import com.hcodekeeper.deanery.services.CreditService;
import com.hcodekeeper.deanery.services.impl.CreditServiceImp;
import com.hcodekeeper.deanery.services.impl.EmployeeServiceImp;
import com.hcodekeeper.deanery.services.impl.GroupServiceImp;
import com.hcodekeeper.deanery.services.impl.StudentServiceImp;
import com.mongodb.client.MongoDatabase;
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
            DatabaseConnectionManager<MongoDatabase> dbConnection = new MongoConnectionManager(config);
            dbConnection.connect();
            MongoDatabase db = dbConnection.getDatabase("Deanery");
            DaoFactory daoFactory = new MongoDaoFactory(db);
            context.setAttribute("databaseConnection", dbConnection);

            context.setAttribute("creditService", new CreditServiceImp(daoFactory));
            context.setAttribute("studentService", new StudentServiceImp(daoFactory));
            context.setAttribute("groupService", new GroupServiceImp(daoFactory));
            context.setAttribute("employeeService", new EmployeeServiceImp(daoFactory));

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
}
