/*
 * DaoBase.java
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
import java.util.List;

import org.hibernate.SessionFactory;

/**
 * * @author nbikkasani@directv.com
 * 
 */
public interface DaoBase<K extends Serializable, T> {

    public T get(K id);

    public T save(T record);

    public void save(T record, String createdBy);

    public void delete(T record);

    public void update(T record);

    public void update(T record, String updatedBy);

    public void saveOrUpdate(T record);

    public void saveOrUpdate(T record, String updatedBy);

    public T merge(T record);

    public List<T> getAll();

    public List<T> getAllOrderBy(String[] orderBys, char[] ascOrDesc);

    public void executeStoreProcedure(final String procedure, final String... parameters);

    public SessionFactory getsessionFactory();

    public void setReadOnlySession();

    public void clearSession();

    public void flushSession();

    /**
     * @param object
     */
    void evict(T object);

    void databaseQuery(String query);

}
