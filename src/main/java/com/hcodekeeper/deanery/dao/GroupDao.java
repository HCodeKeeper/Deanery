package com.hcodekeeper.deanery.dao;

import com.hcodekeeper.deanery.customExceptions.RecordDoesntExist;
import com.hcodekeeper.deanery.models.Employee;
import com.hcodekeeper.deanery.models.Group;

import java.util.Collection;

public interface GroupDao extends Dao<Group> {
    Collection<Group> getByAuthor(Employee author);

    Group getByName(String name);

    void insert(String name);

    Collection<Group> getByStudentName(String name);

    void addStudent(String groupName, String studentName) throws RecordDoesntExist;

    void deleteStudent(String groupName, String studentName) throws RecordDoesntExist;

    void changeName(String previousName, String newName) throws RecordDoesntExist;

    void delete(String name) throws RecordDoesntExist;
}
