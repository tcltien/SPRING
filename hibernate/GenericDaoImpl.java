/*
 * GenericDaoImpl.java
 * 
 * Copyright 2014 DIRECTV, Inc.
 * An Unpublished Work.  All Rights Reserved.
 *
 * DIRECTV PROPRIETARY:  The information contained in or disclosed by this
 * document is considered proprietary by DIRECTV, Inc.  This document and/or the
 * information contained therein shall not be duplicated nor disclosed in whole
 * or in part without the specific written permission of DIRECTV, Inc.
 */
package com.directv.mlb.persistence.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.dialect.Dialect;
import org.springframework.beans.factory.annotation.Autowired;

import com.directv.mlb.persistence.dao.IGenericDao;

/**
 * This class implements the generic DAO.
 * 
 * @author thoivt
 */
@SuppressWarnings("unchecked")
public class GenericDaoImpl<T> implements IGenericDao<T> {

    @Autowired
    protected SessionFactory sessionFactory;

    protected Class<T> entityClass;

    /**
     * Default constructor.
     * 
     */
    public GenericDaoImpl() {
        Type e = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) e;
        entityClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public Session getSession() {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException ex) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(T t) {
        getSession().save(t);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(T t) {
        getSession().update(t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveOrUpdate(T t) {
        getSession().saveOrUpdate(t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(T t) {
        getSession().delete(t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Integer id) {
        // get object
        T t = get(id);
        if (t != null) {
            getSession().delete(t);
        }
    }

    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public List<T> findAll() {
        return findAll(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> findAll(Order order) {
        Criteria crit = getSession().createCriteria(entityClass);
        if (order != null) {
            crit.addOrder(order);
        }
        return crit.list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> find(Criterion criterion) {
        return find(criterion, null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> find(Criterion criterion, Order order) {
        Criteria crit = getSession().createCriteria(entityClass).add(criterion);
        if (order != null) {
            crit.addOrder(order);
        }
        return crit.list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> find(String columnName, Object columnValue) {
        return getSession().createCriteria(entityClass).add(Restrictions.eq(columnName, columnValue)).list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T search(String columnName, Object value) {
        return (T) getSession().createCriteria(entityClass).add(Restrictions.eq(columnName, value)).uniqueResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> exec(Query query) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T get(Integer id) {
        return (T) getSession().get(entityClass, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void merge(T t) {
        getSession().merge(t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void evict(T t) {
        getSession().evict(t);
    }

    /**
     * {@inheritDoc}
     */
    public void batchUpdate(List<T> lst) {
        Session session = getSession();
        int batchSize = Integer.valueOf(Dialect.DEFAULT_BATCH_SIZE);

        for (int i = 0; i < lst.size(); i++) {
            session.saveOrUpdate(lst.get(i));
            if (i > 0 && i % batchSize == 0) {
                session.flush();
                session.clear();
            }
        }
    }
}