package com.hcodekeeper.deanery.dao.impl.mongo;

import com.hcodekeeper.deanery.customExceptions.RecordDoesntExist;
import com.hcodekeeper.deanery.dao.GroupDao;
import com.hcodekeeper.deanery.dao.StudentDao;
import com.hcodekeeper.deanery.models.Group;
import com.hcodekeeper.deanery.models.Student;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.oracle.wls.shaded.org.apache.regexp.RE;
import org.bson.types.ObjectId;

public class MongoGroupDao extends AbstractMongoDao<Group> implements GroupDao {
    private StudentDao studentDao;

    MongoGroupDao(MongoDatabase db, StudentDao studentDao) {
        super(db);
        this.collection = db.getCollection("Group", Group.class);
        this.studentDao = studentDao;
    }

    @Override
    public Group getByName(String name) throws RecordDoesntExist {
        Group group = collection.find(Filters.eq("name", name)).first();
        if(group != null){
            return group;
        }
        else {
            throw new RecordDoesntExist("Group with this name isn't recorded");
        }
    }

    @Override
    public void insert(String name) {
        insert(new Group().setName(name));
    }

    @Override
    public Group getByStudentName(String name) throws RecordDoesntExist {
        try {
            Student student = studentDao.getByName(name);

            if (student != null){
                Group group = collection.find(Filters.eq("_id", student.getGroupId())).first();
                return group;
            }
            return null;
        } catch (RecordDoesntExist e){
            throw e;
        }
    }

    @Override
    public void addStudent(String groupName, String studentName) throws RecordDoesntExist {
        Group group = collection.find(Filters.eq("name", groupName)).first();
        if(group != null){
            Student student = studentDao.getByName(studentName);
            if (student != null){
                deleteStudent(student.getGroupId(), studentName);
                student.setGroupId(group.getId());
                studentDao.update(student);
                group.getStudentIds().add(student.getId());
                update(group);
            }
        }
    }

    private void deleteStudent(ObjectId groupId, String studentName) throws RecordDoesntExist{
        Group group = collection.find(Filters.eq("_id", groupId)).first();
        if( group != null){
            Student student = studentDao.getByName(studentName);
            if(student != null){
                group.getStudentIds().remove(student);
                student.setGroupId(null);
                studentDao.update(student);
                update(group);
                return;
            }
        }
        throw new RecordDoesntExist("Either student or group doesn't exist");
    }

    @Override
    public void deleteStudent(String groupName, String studentName) throws RecordDoesntExist {

    }

    @Override
    public void changeName(String previousName, String newName) throws RecordDoesntExist {
        Group group = collection.find(Filters.eq("name", previousName)).first();
        if(group != null){
            group.setName(newName);
            update(group);
        }
    }

    @Override
    public void delete(String name) throws RecordDoesntExist {
        Group group = collection.find(Filters.eq("name", name)).first();
        if(group != null){
            delete(group);
        }
    }
}
