package com.hcodekeeper.deanery.services.impl;

import com.hcodekeeper.deanery.dao.CreditsDao;
import com.hcodekeeper.deanery.dao.DaoFactory;
import com.hcodekeeper.deanery.dao.StudentDao;
import com.hcodekeeper.deanery.models.Student;
import com.hcodekeeper.deanery.models.identifiers.Role;
import com.hcodekeeper.deanery.services.StudentService;
import org.bson.types.ObjectId;
import static com.hcodekeeper.deanery.models.identifiers.Role.STUDENT;


public class StudentServiceImp implements StudentService {

    private DaoFactory daoFactory;

    public StudentServiceImp(DaoFactory daoFactory){

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
    public void add(String login, String password, String name) {
        StudentDao studentDao = getDaoFactory().getStudentDao();
        CreditsDao creditsDao = getDaoFactory().getCreditsDao();

        studentDao.insert(name);
        creditsDao.insert(login, password, Role.STUDENT);
        ObjectId creditsId = creditsDao.getByLoginPassRole(login, password, Role.STUDENT).getId();
        studentDao.attachCreditsId(name, creditsId);
    }

    @Override
    public Student get(String name) {
        return getDaoFactory().getStudentDao().getByName(name);
    }

    @Override
    public void changeName(String previousName, String newName) {
        getDaoFactory().getStudentDao().changeName(previousName, newName);
    }

    @Override
    public void delete(String name) {
        getDaoFactory().getStudentDao().delete(name);
    }
}
