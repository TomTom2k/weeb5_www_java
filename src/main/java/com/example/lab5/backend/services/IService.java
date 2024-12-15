package com.example.lab5.backend.services;

import java.util.List;

public interface IService<T> {
    T save(T entity);
    T update(T entity);
    T delete(T entity);
    T findById(Long id);
    List<T> findAll();
}
