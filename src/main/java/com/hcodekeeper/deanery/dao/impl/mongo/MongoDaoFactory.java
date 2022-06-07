package com.hcodekeeper.deanery.dao.impl.mongo;

import com.hcodekeeper.deanery.dao.*;
import com.mongodb.client.MongoDatabase;

public class MongoDaoFactory implements DaoFactory {
    MongoDatabase db;
    GroupDao groupDao;
    StudentDao studentDao;
    CreditsDao creditsDao;
    EmployeeDao employeeDao;

    public MongoDaoFactory(MongoDatabase db){
        this.db = db;
        studentDao = new MongoStudentDao(this.db);
        creditsDao = new MongoCreditsDao(this.db);
        groupDao = new MongoGroupDao(this.db, studentDao);
        employeeDao = new MongoEmployeeDao(this.db);
    }

    @Override
    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    @Override
    public StudentDao getStudentDao() {
        return studentDao;
    }

    @Override
    public GroupDao getGroupDao() {
        return groupDao;
    }

    @Override
    public CreditsDao getCreditsDao() {
        return creditsDao;
    }
}
