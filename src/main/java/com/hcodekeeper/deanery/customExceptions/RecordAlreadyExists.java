package com.hcodekeeper.deanery.customExceptions;

public class RecordAlreadyExists extends Exception{
    public RecordAlreadyExists(String message){
        super(message);
    }
}
