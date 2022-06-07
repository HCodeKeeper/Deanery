package com.hcodekeeper.deanery.services;

import com.hcodekeeper.deanery.customExceptions.RecordDoesntExist;
import com.hcodekeeper.deanery.models.Student;

public interface StudentService {
    void add(String login, String password, String name) throws RecordDoesntExist;
    Student get(String name);
    void changeName(String previousName, String newName);
    void delete(String name);
}
