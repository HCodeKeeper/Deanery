package com.hcodekeeper.deanery.dao;

public interface Dao<T> {
    void insert(T entity);
    T get(String id);
    void update(T entity);
    void delete(T entity);
}
