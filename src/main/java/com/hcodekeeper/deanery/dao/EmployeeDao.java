package com.hcodekeeper.deanery.dao;

import com.hcodekeeper.deanery.customExceptions.RecordDoesntExist;
import com.hcodekeeper.deanery.models.Employee;
import org.bson.types.ObjectId;

public interface EmployeeDao extends Dao<Employee> {
    void insert(String name);

    void attachCreditsId(String name, ObjectId id) throws RecordDoesntExist;
}
