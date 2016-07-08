/*
 * IGenericDao.java
 * 
 * Copyright 2014 DIRECTV, Inc.
 * An Unpublished Work.  All Rights Reserved.
 *
 * DIRECTV PROPRIETARY:  The information contained in or disclosed by this
 * document is considered proprietary by DIRECTV, Inc.  This document and/or the
 * information contained therein shall not be duplicated nor disclosed in whole
 * or in part without the specific written permission of DIRECTV, Inc.
 */
package com.directv.mlb.persistence.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

/**
 * This is a generic DAO.
 * 
 * @author thoivt
 */
public interface IGenericDao<T> {

    /**
     * Hold the Hibernate session factory
     * 
     * @return {@link SessionFactory}
     */
    SessionFactory getSessionFactory();

    /**
     * Hold the current Hibernate Session
     * 
     * @return {@link Session}
     */
    Session getSession();

    /**
     * 
     * Save entity T.
     * 
     * @param t
     * @return void
     */
    void save(T t);

    /**
     * 
     * Update entity T.
     * 
     * @param t
     * @return void
     */
    void update(T t);

    /**
     * 
     * Save or update entity.
     * 
     * @param t
     * @return void
     */
    void saveOrUpdate(T t);

    /**
     * 
     * Delete entity T.
     * 
     * @param t
     * @return void
     */
    void delete(T t);

    /**
     * Delete entity by ID
     *
     * @param id
     * @return
     */
    void delete(Integer id);

    /**
     * Get all elements from table T.
     * 
     * @return
     */
    List<T> findAll();

    /**
     * 
     * Get all elements from table T & sort by order.
     * 
     * @param order
     * @return
     */
    List<T> findAll(Order order);

    /**
     * 
     * Get list of T with predefined criterion.
     * 
     * @param criterion
     * @return
     */
    List<T> find(Criterion criterion);

    /**
     * 
     * Get list of T which predefined criterion & order
     * 
     * @param criterion
     * @param order
     * @return
     */
    List<T> find(Criterion criterion, Order order);

    /**
     * 
     * Get list of T by a column.
     * 
     * @param columnName
     * @param columnValue
     * @return
     */
    List<T> find(String columnName, Object columnValue);

    /**
     * 
     * Search entity T by a column.
     * 
     * @param columnName
     * @param value
     * @return
     */
    T search(String columnName, Object value);

    /**
     * Execute a query.
     * 
     * @param query
     * @return
     */
    List<T> exec(Query query);

    /**
     * Get entity by Id
     * 
     * @param id
     * @return
     */
    T get(Integer id);

    /**
     * Merge entity
     * 
     * @param t
     */
    void merge(T t);

    /**
     * 
     * Evict entity.
     *
     * @param t
     */
    void evict(T t);

    /**
     * 
     * Update a list of entities.
     *
     * @param lst
     */
    void batchUpdate(List<T> lst);
}
