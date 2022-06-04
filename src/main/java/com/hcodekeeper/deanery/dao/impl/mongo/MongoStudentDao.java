package com.hcodekeeper.deanery.dao.impl.mongo;

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
    public Student getByName(String name) {
        return collection.find(Filters.eq("name", name)).first();
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
    public void attachCreditsId(String name, ObjectId id) {
        getByName(name).setCreditsId(id);
    }

    @Override
    public void changeName(String previousName, String newName) {
        Student student = getByName(previousName);
        student.setName(newName);
        update(student);
    }

    @Override
    public void delete(String name) {
        delete(getByName(name));
    }
}
