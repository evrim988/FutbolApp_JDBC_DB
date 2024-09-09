package org.example.repository;

import java.util.List;
import java.util.Optional;

public interface ICrud<T> {

    void save(T t);
    void softDelete(int id);
    void hardDelete(int id);
    void update(T t);
    List<T> findAll();
    Optional<T> findById(int id);
}
