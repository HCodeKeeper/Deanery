package com.hcodekeeper.deanery.services;

import com.hcodekeeper.deanery.customExceptions.RecordAlreadyExists;
import com.hcodekeeper.deanery.customExceptions.RecordDoesntExist;
import com.hcodekeeper.deanery.models.Group;

import java.util.Collection;

public interface GroupService {
    void add(String name) throws RecordAlreadyExists;
    void addStudent(String groupName, String studentName) throws RecordDoesntExist;
    void deleteStudent(String groupName, String studentName) throws RecordDoesntExist;
    Collection<Group> getByStudentName(String name);
    void changeName(String previousName, String newName) throws RecordDoesntExist;
    void delete(String name) throws RecordDoesntExist;
}
