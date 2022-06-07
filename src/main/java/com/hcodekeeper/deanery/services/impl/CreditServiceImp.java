package com.hcodekeeper.deanery.services.impl;

import com.hcodekeeper.deanery.dao.CreditsDao;
import com.hcodekeeper.deanery.dao.Dao;
import com.hcodekeeper.deanery.dao.DaoFactory;
import com.hcodekeeper.deanery.models.UserCredentials;
import com.hcodekeeper.deanery.models.identifiers.Role;
import com.hcodekeeper.deanery.services.AbstractService;
import com.hcodekeeper.deanery.services.CreditService;
//it's only possible to access role functions and not any fields of its user
public class CreditServiceImp extends AbstractService implements CreditService {

    public CreditServiceImp(DaoFactory daoFactory){
        super(daoFactory);
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
