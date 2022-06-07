package com.hcodekeeper.deanery.services.impl;

import com.hcodekeeper.deanery.customExceptions.RecordDoesntExist;
import com.hcodekeeper.deanery.dao.CreditsDao;
import com.hcodekeeper.deanery.dao.Dao;
import com.hcodekeeper.deanery.dao.DaoFactory;
import com.hcodekeeper.deanery.dao.EmployeeDao;
import com.hcodekeeper.deanery.models.identifiers.Role;
import com.hcodekeeper.deanery.services.AbstractService;
import com.hcodekeeper.deanery.services.EmployeeService;
import org.bson.types.ObjectId;

public class EmployeeServiceImp extends AbstractService implements EmployeeService {
    protected DaoFactory daoFactory;

    public EmployeeServiceImp(DaoFactory daoFactory){
        super(daoFactory);
    }

    @Override
    public void add(String name, String login, String password) throws RecordDoesntExist {
        EmployeeDao employeeDao = getDaoFactory().getEmployeeDao();
        CreditsDao creditsDao = getDaoFactory().getCreditsDao();

        employeeDao.insert(name);
        creditsDao.insert(login, password, Role.EMPLOYEE);
        ObjectId creditsId = creditsDao.getByLoginPassRole(login, password, Role.EMPLOYEE).getId();
        try {
            employeeDao.attachCreditsId(name, creditsId);
        } catch (RecordDoesntExist | IllegalArgumentException e){
            throw e;
        }
    }
}
