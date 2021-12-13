package edu.labs.repositories;

import java.util.List;

import edu.labs.exceptions.BaseException;

public interface CrudRepository<T> {

    List<T> getAll();

    T getById(Long id) throws BaseException;

    T update(T item) throws BaseException;

    void remove(T item);

    Long create(T item);
}
