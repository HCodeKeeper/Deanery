package com.hcodekeeper.deanery.dao;

import com.hcodekeeper.deanery.customExceptions.RecordDoesntExist;
import com.hcodekeeper.deanery.models.Employee;
import com.hcodekeeper.deanery.models.Group;

import java.util.Collection;

public interface GroupDao extends Dao<Group> {

    Group getByName(String name) throws RecordDoesntExist;

    void insert(String name);

    Group getByStudentName(String name) throws RecordDoesntExist;

    void addStudent(String groupName, String studentName) throws RecordDoesntExist;

    void deleteStudent(String groupName, String studentName) throws RecordDoesntExist;

    void changeName(String previousName, String newName) throws RecordDoesntExist;

    void delete(String name) throws RecordDoesntExist;
}
