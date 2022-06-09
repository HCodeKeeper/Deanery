package com.hcodekeeper.deanery.models;

import com.hcodekeeper.deanery.models.identifiers.User;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;


public class Student extends User implements AbstractPojo{
    @BsonProperty(value = "_id")
    private ObjectId id;
    @BsonProperty
    private String name;
    @BsonProperty
    private ObjectId creditsId;

    public ObjectId getCreditsId() {
        return creditsId;
    }

    public void setCreditsId(ObjectId creditsId) {
        this.creditsId = creditsId;
    }

    @BsonProperty
    private ObjectId groupId;

    public Student(){

    }

    public ObjectId getId() {
        return id;
    }

    @Override
    public AbstractPojo setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public ObjectId getGroupId() {
        return groupId;
    }

    public void setGroupId(ObjectId groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }
}
