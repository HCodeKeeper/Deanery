package com.hcodekeeper.deanery.services.impl;
import com.hcodekeeper.deanery.customExceptions.RecordAlreadyExists;
import com.hcodekeeper.deanery.customExceptions.RecordDoesntExist;
import com.hcodekeeper.deanery.dao.DaoFactory;
import com.hcodekeeper.deanery.dao.GroupDao;
import com.hcodekeeper.deanery.dao.StudentDao;
import com.hcodekeeper.deanery.models.Group;
import com.hcodekeeper.deanery.models.Student;
import com.hcodekeeper.deanery.services.GroupService;

import java.util.Collection;

public class GroupServiceImp implements GroupService {
    DaoFactory daoFactory;

    public GroupServiceImp(DaoFactory daoFactory){
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

    @Override
    public void add(String name) throws RecordAlreadyExists{
        getDaoFactory().getGroupDao().insert(name);
    }

    @Override
    public void addStudent(String groupName, String studentName) throws RecordDoesntExist {
        getDaoFactory().getGroupDao().addStudent(groupName, studentName);
    }

    @Override
    public void deleteStudent(String groupName, String studentName) throws RecordDoesntExist {
        getDaoFactory().getGroupDao().deleteStudent(groupName, studentName);
    }

    @Override
    public Collection<Group> getByStudentName(String name) {
        return getDaoFactory().getGroupDao().getByStudentName(name);
    }

    @Override
    public void changeName(String previousName, String newName) throws RecordDoesntExist {
        getDaoFactory().getGroupDao().changeName(previousName, newName);
    }

    @Override
    public void delete(String name) throws RecordDoesntExist {
        getDaoFactory().getGroupDao().delete(name);
    }
}
