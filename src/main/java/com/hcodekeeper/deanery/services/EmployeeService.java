package com.hcodekeeper.deanery.services;

import com.hcodekeeper.deanery.customExceptions.RecordDoesntExist;

public interface EmployeeService {
    void add(String name, String login, String password) throws RecordDoesntExist;
}
