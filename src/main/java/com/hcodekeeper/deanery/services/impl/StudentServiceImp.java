package com.hcodekeeper.deanery.services.impl;

import com.hcodekeeper.deanery.customExceptions.RecordDoesntExist;
import com.hcodekeeper.deanery.dao.CreditsDao;
import com.hcodekeeper.deanery.dao.DaoFactory;
import com.hcodekeeper.deanery.dao.StudentDao;
import com.hcodekeeper.deanery.models.Student;
import com.hcodekeeper.deanery.models.identifiers.Role;
import com.hcodekeeper.deanery.services.AbstractService;
import com.hcodekeeper.deanery.services.StudentService;
import org.bson.types.ObjectId;


public class StudentServiceImp extends AbstractService implements StudentService {

    private DaoFactory daoFactory;

    public StudentServiceImp(DaoFactory daoFactory){
        super(daoFactory);
    }

    public DaoFactory getDaoFactory() {
        return daoFactory;
    }

    public void setDaoFactory(DaoFactory daoFactory) {
        if (daoFactory == null){
            throw new IllegalArgumentException("daoFactory can't be set to null");
        }
        this.daoFactory = daoFactory;
    }

    @Override
    public void add(String login, String password, String name) throws RecordDoesntExist {
        StudentDao studentDao = getDaoFactory().getStudentDao();
        CreditsDao creditsDao = getDaoFactory().getCreditsDao();

        studentDao.insert(name);
        creditsDao.insert(login, password, Role.STUDENT);
        ObjectId creditsId = creditsDao.getByLoginPassRole(login, password, Role.STUDENT).getId();
        try {
            studentDao.attachCreditsId(name, creditsId);
        } catch (RecordDoesntExist e){
            throw e;
        }

    }

    @Override
    public Student get(String name) {
        try {
            return getDaoFactory().getStudentDao().getByName(name);
        } catch (RecordDoesntExist e){
            return null;
        }
    }

    @Override
    public void changeName(String previousName, String newName) {
        try {
            getDaoFactory().getStudentDao().changeName(previousName, newName);
        } catch (RecordDoesntExist e){
            return;
        }
    }

    @Override
    public void delete(String name) {
        getDaoFactory().getStudentDao().delete(name);
    }

    @Override
    public Student get(ObjectId id) throws RecordDoesntExist{
        try {
            return getDaoFactory().getStudentDao().get(id);
        } catch (RecordDoesntExist e){
            throw e;
        }
    }
}
