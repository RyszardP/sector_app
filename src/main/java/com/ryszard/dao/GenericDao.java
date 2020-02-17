package com.ryszard.dao;

import com.ryszard.exception.DaoException;

import java.util.List;


public interface GenericDao<T, K> {

    List<T> findAll() throws DaoException;

    T findById(K id) throws DaoException;

    void delete(K id) throws DaoException;

    T save(T entity) throws DaoException;

    T update(T entity) throws DaoException;

    List<T> search(T entity) throws DaoException;


}