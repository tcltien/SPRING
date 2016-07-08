/*
 * IJobRoleDao.java
 *
 * Copyright (c) 2014 DIRECTV, Inc.
 * An Unpublished Work.  All Rights Reserved.
 *
 * DIRECTV PROPRIETARY:  The information contained in or disclosed by this
 * document is considered proprietary by DIRECTV, Inc.  This document and/or the
 * information contained therein shall not be duplicated nor disclosed in whole
 * or in part without the specific written permission of DIRECTV, Inc.
 */
package com.directv.mlb.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.directv.mlb.persistence.dao.IJobRoleDao;
import com.directv.mlb.pojo.Jobrole;

/**
 * Implementation of IJobRoleDao interfaces.
 * 
 * @author ninhhp
 * 
 */

@Repository
public class JobRoleDaoImpl extends GenericDaoImpl<Jobrole> implements IJobRoleDao {

}
