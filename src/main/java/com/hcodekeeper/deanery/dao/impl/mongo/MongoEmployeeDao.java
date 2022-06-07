package com.hcodekeeper.deanery.dao.impl.mongo;

import com.hcodekeeper.deanery.customExceptions.RecordDoesntExist;
import com.hcodekeeper.deanery.dao.DaoFactory;
import com.hcodekeeper.deanery.dao.EmployeeDao;
import com.hcodekeeper.deanery.models.Employee;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.types.ObjectId;

public class MongoEmployeeDao extends AbstractMongoDao<Employee> implements EmployeeDao {

    MongoEmployeeDao(MongoDatabase db){
        super(db);
        collection = db.getCollection("Employee", Employee.class);
    }

    @Override
    public void insert(String name) {
        collection.insertOne(new Employee().setName(name));
    }

    @Override
    public void attachCreditsId(String name, ObjectId id) throws RecordDoesntExist {
        if(id == null){
            throw new NullPointerException("Credits id is null");
        }
        Employee employee = collection.find(Filters.eq("name", name)).first();
        if (employee != null){
            employee.setCreditsId(id);
            update(employee);
        }
        else{
            throw new RecordDoesntExist("Employee isn't recorded");
        }
    }
}
