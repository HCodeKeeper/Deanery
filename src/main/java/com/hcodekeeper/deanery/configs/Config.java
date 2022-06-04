package com.hcodekeeper.deanery.configs;

import com.hcodekeeper.deanery.customExceptions.DatabaseURINotFound;

import java.io.File;

public interface Config {
    String getDatabaseURI() throws DatabaseURINotFound;
    void setConfigFile(File file) throws DatabaseURINotFound;
    File getConfigFile();
    void updateParameters() throws DatabaseURINotFound;
}
