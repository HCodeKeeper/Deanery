package com.hcodekeeper.deanery.dao;

import com.hcodekeeper.deanery.customExceptions.RecordDoesntExist;
import org.bson.types.ObjectId;

public interface Dao<T> {
    void insert(T entity);
    T get(ObjectId id) throws RecordDoesntExist;
    void update(T entity);
    void delete(T entity);
}
