package com.hcodekeeper.deanery.configs;

import com.hcodekeeper.deanery.customExceptions.DatabaseURINotFound;

import java.io.*;

public class ConfigImpl implements Config{
    private String databaseURI;
    private File configFile;

    public ConfigImpl(File file) throws DatabaseURINotFound{
        setConfigFile(file);
    }

    @Override
    public String getDatabaseURI() throws DatabaseURINotFound {
        if(databaseURI == null){
            throw new DatabaseURINotFound("DB connection URI isn't presented in configs");
        }

        return databaseURI;
    }

    public void updateParameters() throws DatabaseURINotFound{
        parseConfigFile();
    }

    private void resetParameters(){
        databaseURI = null;
    }

    private void parseConfigFile() throws DatabaseURINotFound {
        resetParameters();
        try(BufferedReader br = new BufferedReader(new FileReader(configFile))){
            String line = "";
            while ((line = br.readLine()) != null){
                if(line.contains("db_connection_uri")){
                    databaseURI = line.substring(line.indexOf("\"")+1, line.length()-1);
                }
            }
        }catch (IOException e){
            throw new DatabaseURINotFound("Couldn't read from configs", e);
        }
    }

    @Override
    public void setConfigFile(File file) throws DatabaseURINotFound{
        if(file != null){
            configFile = file;
            updateParameters();
        }
        else{
            throw new IllegalArgumentException(" File was set to null");
        }
    }

    @Override
    public File getConfigFile() {
        return configFile;
    }
}
