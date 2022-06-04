package com.hcodekeeper.deanery.models;

import com.hcodekeeper.deanery.customExceptions.NameDoesntExist;
import com.hcodekeeper.deanery.models.identifiers.User;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class Employee extends User implements AbstractPojo{
    @BsonProperty(value = "_id")
    private ObjectId id;
    @BsonProperty
    private String name;
    private ObjectId creditsId;

    public void setName(String name) {
        this.name = name;
    }

    public ObjectId getCreditsId() {
        return creditsId;
    }

    public void setCreditsId(ObjectId credits) {
        this.creditsId = creditsId;
    }

    public Employee(){

    }

    public Employee(String name){
        this.name = name;
    }

    public ObjectId getId(){
        return id;
    }

    @Override
    public AbstractPojo setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public String getName() throws NameDoesntExist{
        if(name != null) {
            return name;
        }
        else{
            throw new NameDoesntExist("Name is set to null");
        }
    }
}
