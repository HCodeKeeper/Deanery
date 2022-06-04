package com.hcodekeeper.deanery.dao;


public interface DaoFactory {
    EmployeeDao getEmployeeDao();

    StudentDao getStudentDao();

    GroupDao getGroupDao();

    CreditsDao getCreditsDao();
}
