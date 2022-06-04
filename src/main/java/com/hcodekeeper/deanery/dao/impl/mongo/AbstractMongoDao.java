package com.hcodekeeper.deanery.dao.impl.mongo;

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

    public T get(String id){
        return collection.find(Filters.eq("_id", new ObjectId(id))).first();
    }

    public void update(T entity){ // allows to update with resources which are already recorded
        T prevEntity = collection.find(Filters.eq("_id", entity.getId())).first();
        if(prevEntity != null){
            collection.replaceOne(Filters.eq("_id", prevEntity.getId()), entity);
        }
        else{
            collection.insertOne(entity);
        }

    }

    public void delete(T entity){
        collection.deleteOne(Filters.eq("_id", entity.getId()));
    }
}
