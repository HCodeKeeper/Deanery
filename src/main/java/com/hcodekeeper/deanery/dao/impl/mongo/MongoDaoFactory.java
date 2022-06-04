package com.hcodekeeper.deanery.dao.impl.mongo;

import com.hcodekeeper.deanery.dao.*;
import com.mongodb.client.MongoDatabase;

public class MongoDaoFactory implements DaoFactory {
    MongoDatabase db;
    GroupDao groupDao;
    StudentDao studentDao;
    CreditsDao creditsDao;

    public MongoDaoFactory(MongoDatabase db){
        this.db = db;
    }

    @Override
    public EmployeeDao getEmployeeDao() {
        return null;
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
