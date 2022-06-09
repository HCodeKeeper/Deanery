package com.hcodekeeper.deanery.services;

import com.hcodekeeper.deanery.customExceptions.RecordDoesntExist;
import com.hcodekeeper.deanery.models.Student;
import org.bson.types.ObjectId;

public interface StudentService {
    void add(String login, String password, String name) throws RecordDoesntExist;
    Student get(String name);
    void changeName(String previousName, String newName) throws RecordDoesntExist;
    void delete(String name) throws RecordDoesntExist;
    Student get(ObjectId id) throws RecordDoesntExist;
}
