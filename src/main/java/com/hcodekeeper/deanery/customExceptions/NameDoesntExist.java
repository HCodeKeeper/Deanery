package com.hcodekeeper.deanery.customExceptions;

public class NameDoesntExist extends Exception{
    public NameDoesntExist(String message){
        super(message);
    }
}
