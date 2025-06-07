package com.ToeicPreBackend.service;

import java.util.List;

public interface CrudService<T, ID> {
    T create(T entity);
    T update(ID id, T entity);
    T getById(ID id);
    void delete(ID id);
    List<T> getAll();
}