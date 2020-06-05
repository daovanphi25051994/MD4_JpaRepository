package com.codegym.service;

import java.util.List;

public interface IService<T> {
    List<T> getAll();
    T getOne(Long id);
    T save(T model);
    void delete(Long id);
    T update(Long id, T model);
}
