package com.hcodekeeper.deanery.dao;

import com.hcodekeeper.deanery.models.Group;
import com.hcodekeeper.deanery.models.Student;
import com.hcodekeeper.deanery.models.identifiers.Role;
import org.bson.types.ObjectId;

import java.util.Collection;

public interface StudentDao extends Dao<Student> {
    Student getByName(String name);
    Collection<Student> getByGroupName(String groupName);
    void insert(String name);
    void attachCreditsId(String name, ObjectId id);
    void changeName(String previousName, String newName);
    void delete(String name);
}
