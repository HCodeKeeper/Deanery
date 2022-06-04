package com.hcodekeeper.deanery.services.impl;

import com.hcodekeeper.deanery.dao.CreditsDao;
import com.hcodekeeper.deanery.dao.Dao;
import com.hcodekeeper.deanery.dao.DaoFactory;
import com.hcodekeeper.deanery.models.UserCredentials;
import com.hcodekeeper.deanery.models.identifiers.Role;
import com.hcodekeeper.deanery.services.CreditService;
//it's only possible to access role functions and not any fields of its user
public class CreditServiceImp implements CreditService {
    DaoFactory daoFactory;

    public CreditServiceImp(DaoFactory daoFactory){
        setDaoFactory(daoFactory);
    }

    public void setDaoFactory(DaoFactory daoFactory){
        if (daoFactory == null){
            throw new IllegalArgumentException("daoFactory can't be set to null");
        }
        this.daoFactory = daoFactory;
    }

    public DaoFactory getDaoFactory(){
        return daoFactory;
    }

    public boolean isRegistered(String login, String password, Role role){
        CreditsDao creditsDao = getDaoFactory().getCreditsDao();
        UserCredentials credits = creditsDao.getByLoginPassRole(login, password, role);
        if (credits == null){
            return false;
        }
        return true;
    }
}
