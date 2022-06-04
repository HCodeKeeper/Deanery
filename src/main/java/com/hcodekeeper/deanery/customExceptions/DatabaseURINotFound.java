package com.hcodekeeper.deanery.customExceptions;

public class DatabaseURINotFound extends Exception {
    public DatabaseURINotFound(String message, Throwable cause){
        super(message, cause);
    }

    public DatabaseURINotFound(String message){
        super(message);
    }
}
