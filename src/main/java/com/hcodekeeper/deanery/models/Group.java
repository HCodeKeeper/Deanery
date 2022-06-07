package com.hcodekeeper.deanery.models;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class Group implements AbstractPojo{
    @BsonProperty(value = "_id")
    private ObjectId id;
    @BsonProperty
    private TreeSet<ObjectId> studentIds = new TreeSet<>();
    @BsonProperty
    private ObjectId authorId;

    public String getName() {
        return name;
    }

    public Group setName(String name) {
        this.name = name;
        return this;
    }

    private String name;

    public ObjectId getId() {
        return id;
    }

    @Override
    public Group setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public TreeSet<ObjectId> getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(TreeSet<ObjectId> studentIds) {
        this.studentIds = studentIds;
    }

    public ObjectId getAuthorId() {
        return authorId;
    }

    public void setAuthorId(ObjectId authorId) {
        this.authorId = authorId;
    }
}
