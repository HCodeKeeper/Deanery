package com.hcodekeeper.deanery.helpers;

import com.hcodekeeper.deanery.customExceptions.DatabaseURINotFound;
import com.mongodb.MongoCredential;

public interface DatabaseConnectionManager<Database> {
    public void connect() throws DatabaseURINotFound;
    public Database getDatabase(String name);
    public void close();
}
