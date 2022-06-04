package com.hcodekeeper.deanery.listeners;

import com.hcodekeeper.deanery.configs.Config;
import com.hcodekeeper.deanery.configs.ConfigImpl;
import com.hcodekeeper.deanery.helpers.DatabaseConnectionManager;
import com.hcodekeeper.deanery.helpers.MongoConnectionManager;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.File;

@WebListener
public class SessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionBindingEvent event){

    }

    public void sessionDestroyed(HttpSessionBindingEvent event){

    }
}
