package com.hcodekeeper.deanery.services;

import com.hcodekeeper.deanery.dao.DaoFactory;

abstract public class AbstractService {
    protected DaoFactory daoFactory;

    public AbstractService(DaoFactory daoFactory) {
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
}
