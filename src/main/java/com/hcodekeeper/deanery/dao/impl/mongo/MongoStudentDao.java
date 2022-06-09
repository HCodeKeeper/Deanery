package com.hcodekeeper.deanery.dao.impl.mongo;

import com.hcodekeeper.deanery.customExceptions.RecordDoesntExist;
import com.hcodekeeper.deanery.dao.StudentDao;
import com.hcodekeeper.deanery.models.Group;
import com.hcodekeeper.deanery.models.Student;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.types.ObjectId;

import java.util.Collection;
import java.util.TreeSet;

public class MongoStudentDao extends AbstractMongoDao<Student> implements StudentDao {

    public MongoStudentDao(MongoDatabase db) {
        super(db);
        this.collection = db.getCollection("Student", Student.class);
    }

    @Override
    public Student getByName(String name) throws RecordDoesntExist {
        Student student = collection.find(Filters.eq("name", name)).first();
        if(student == null){
            throw new RecordDoesntExist("Student isn't recorded");
        }
        return student;
    }

    @Override
    public Collection<Student> getByGroupName(String groupName) {
        TreeSet<Student> students = new TreeSet<>();
        Group group = db.getCollection("Group", Group.class)
                .find(Filters.eq("name", groupName))
                .first();
        for(ObjectId studentId : group.getStudentIds()){
            students.add(collection.find(Filters.eq("_id", studentId)).first());
        }

        return students;
    }

    @Override
    public void insert(String name) {
        insert(new Student().setName(name));
    }

    @Override
    public void attachCreditsId(String name, ObjectId id) throws RecordDoesntExist{
        if(id == null){
            throw new NullPointerException("Credits id is set to null");
        }
        try {
            Student student = getByName(name);
            student.setCreditsId(id);
            update(student);
        } catch (RecordDoesntExist e){
            throw e;
        }
    }

    @Override
    public void changeName(String previousName, String newName) throws RecordDoesntExist{
        try {
            Student student = getByName(previousName);
            student.setName(newName);
            update(student);
        } catch (RecordDoesntExist e){
            throw e;
        }
    }

    @Override
    public void delete(String name) {
        try {
            delete(getByName(name));
        } catch (RecordDoesntExist e){
            return;
        }
    }
}
