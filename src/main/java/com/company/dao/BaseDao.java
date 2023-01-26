package com.company.dao;

import java.util.List;

public interface BaseDao<T,R> {
    T findById(int id);
    List<T> findAll();

    void save(R r);
}
