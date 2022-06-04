package com.hcodekeeper.deanery.customExceptions;

public class RecordDoesntExist extends Exception{
    public RecordDoesntExist(String message){
        super(message);
    }
}
