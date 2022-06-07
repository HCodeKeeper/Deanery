package com.hcodekeeper.deanery.dao.impl.mongo;

import com.hcodekeeper.deanery.customExceptions.RecordDoesntExist;
import com.hcodekeeper.deanery.dao.Dao;
import com.hcodekeeper.deanery.models.AbstractPojo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;

abstract public class AbstractMongoDao<T extends AbstractPojo> implements Dao<T> {

    protected MongoDatabase db;
    protected MongoCollection<T> collection;

    AbstractMongoDao(MongoDatabase db){
        this.db = db;
    }

    public void insert(T entity){
        collection.insertOne(entity);
    }

    public T get(ObjectId id) throws RecordDoesntExist {
        T objectId = collection.find(Filters.eq("_id", id)).first();
        if (objectId != null){
            return objectId;
        }
        throw new RecordDoesntExist("Record with this id doesn't exist");
    }

    public void update(T entity){ // allows to update with resources which are already recorded
        T prevEntity = collection.find(Filters.eq("_id", entity.getId())).first();
        if(prevEntity != null){
            collection.findOneAndReplace(Filters.eq("_id", prevEntity.getId()), entity);
        }
        else{
            collection.insertOne(entity);
        }

    }

    public void delete(T entity){
        collection.deleteOne(Filters.eq("_id", entity.getId()));
    }
}
