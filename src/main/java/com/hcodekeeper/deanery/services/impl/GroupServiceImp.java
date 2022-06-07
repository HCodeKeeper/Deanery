package com.hcodekeeper.deanery.services.impl;
import com.hcodekeeper.deanery.customExceptions.RecordAlreadyExists;
import com.hcodekeeper.deanery.customExceptions.RecordDoesntExist;
import com.hcodekeeper.deanery.dao.DaoFactory;
import com.hcodekeeper.deanery.models.Group;
import com.hcodekeeper.deanery.services.AbstractService;
import com.hcodekeeper.deanery.services.GroupService;

public class GroupServiceImp extends AbstractService implements GroupService {
    DaoFactory daoFactory;

    public GroupServiceImp(DaoFactory daoFactory){
        super(daoFactory);
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
    public Group getByStudentName(String name) throws RecordDoesntExist {
        try {
            return getDaoFactory().getGroupDao().getByStudentName(name);
        } catch (RecordDoesntExist e){
            throw e;
        }
    }

    @Override
    public Group getByName(String name) throws RecordDoesntExist {
        try {
            return getDaoFactory().getGroupDao().getByName(name);
        } catch (RecordDoesntExist e){
            throw e;
        }
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
