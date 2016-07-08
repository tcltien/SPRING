/*
 * DaoBaseImpl.java
 * 
 * Copyright (c) 2013 DIRECTV, Inc.
 * An Unpublished Work.  All Rights Reserved.
 *
 * DIRECTV PROPRIETARY:  The information contained in or disclosed by this
 * document is considered proprietary by DIRECTV, Inc.  This document and/or the
 * information contained therein shall not be duplicated nor disclosed in whole
 * or in part without the specific written permission of DIRECTV, Inc.
 */
package com.directv.sds.common.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.directv.sds.common.pojo.POJOBase;

/**
 * * @author nbikkasani@directv.com
 *
 */
public class DaoBaseImpl<K extends Serializable, T> implements DaoBase<K, T> {

    protected Class<T> entityClass;

    @Autowired
    protected SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public DaoBaseImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[1];
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(K id) {
        return (T) sessionFactory.getCurrentSession().get(entityClass, id);
    }

    @Override
    public T save(T record) {
        sessionFactory.getCurrentSession().save(record);
        return record;
    }

    @Override
    public void save(T record, String createdBy) {
        POJOBase pb = (POJOBase) record;
        pb.setCreatedBy(createdBy);
        pb.setUpdatedBy(createdBy);
        sessionFactory.getCurrentSession().save(record);
    }

    @Override
    public void saveOrUpdate(T record) {
        sessionFactory.getCurrentSession().saveOrUpdate(record);
    }

    @Override
    public void saveOrUpdate(T record, String updatedBy) {
        POJOBase pb = (POJOBase) record;

        if (StringUtils.isEmpty(pb.getCreatedBy())) {
            pb.setCreatedBy(updatedBy);
        }
        pb.setUpdatedBy(updatedBy);
        sessionFactory.getCurrentSession().saveOrUpdate(record);
    }

    @Override
    public void delete(T record) {
        sessionFactory.getCurrentSession().delete(record);
    }

    @Override
    public void update(T record) {
        sessionFactory.getCurrentSession().update(record);
    }

    @Override
    public void update(T record, String updatedBy) {
        POJOBase pb = (POJOBase) record;
        pb.setUpdatedBy(updatedBy);
        sessionFactory.getCurrentSession().update(record);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T merge(T record) {
        return (T) sessionFactory.getCurrentSession().merge(record);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(entityClass)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAllOrderBy(final String[] orderBys, final char[] ascOrDesc) {
        if (orderBys != null && ascOrDesc != null && orderBys.length != ascOrDesc.length) {
            throw new IllegalArgumentException("Length of array paramsters must be equal.");
        }
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(entityClass);
        for (int i = 0; i < orderBys.length; i++) {
            String by = (String) orderBys[i];
            char aord = (char) ascOrDesc[i];
            if (aord == 'A' || aord == 'a')
                criteria.addOrder(Order.asc(by));
            if (aord == 'D' || aord == 'd')
                criteria.addOrder(Order.desc(by));
        }
        return criteria.list();
    }

    @Override
    public void executeStoreProcedure(final String procedure, final String... parameters) {
        Session session = sessionFactory.getCurrentSession();

        Query q = session.createSQLQuery(" { call " + procedure + " }");

        for (int i = 0; i < parameters.length; i++)
            q.setString(i, parameters[i]);

        q.executeUpdate();

    }

    @Override
    public SessionFactory getsessionFactory() {
        return sessionFactory;
    }

    @Override
    public void setReadOnlySession() {
        sessionFactory.getCurrentSession().setFlushMode(FlushMode.MANUAL);
        sessionFactory.getCurrentSession().setDefaultReadOnly(true);
    }

    @Override
    public void clearSession() {
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public void flushSession() {
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void evict(T object) {
        sessionFactory.getCurrentSession().evict(object);
    }

    @Override
    public void databaseQuery(String query) {
        sessionFactory.getCurrentSession().createSQLQuery(query).executeUpdate();
    }
}
