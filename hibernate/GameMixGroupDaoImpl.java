/*
 * GameMixGroupDaoImpl.java
 * 
 * Copyright 2015 DIRECTV, Inc.
 * An Unpublished Work.  All Rights Reserved.
 *
 * DIRECTV PROPRIETARY:  The information contained in or disclosed by this
 * document is considered proprietary by DIRECTV, Inc.  This document and/or the
 * information contained therein shall not be duplicated nor disclosed in whole
 * or in part without the specific written permission of DIRECTV, Inc.
 */
package com.directv.mlb.persistence.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.directv.mlb.common.Constants;
import com.directv.mlb.common.utils.DateUtils;
import com.directv.mlb.persistence.dao.IGameMixGroupDao;
import com.directv.mlb.pojo.Gamemix;
import com.directv.mlb.pojo.Gamemixgroup;

/**
 * Implementation of IGameMixGroupDao interfaces.
 * 
 * @author ninhhp
 */
@Repository
public class GameMixGroupDaoImpl extends GenericDaoImpl<Gamemixgroup> implements IGameMixGroupDao {

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings({ "unchecked" })
    @Override
    public List<Gamemixgroup> getActiveGameMixGroups(String date) {
        Date d1 = DateUtils.toDate(date + " " + Constants.MIN_TIME);
        Date d2 = DateUtils.toDate(date + " " + Constants.MAX_TIME);
        List<Gamemixgroup> groups = getSession().createCriteria(Gamemixgroup.class, "gamemixgroup")
                .add(Restrictions.eq("status", Constants.STATUS_ACTIVE))
                .add(Restrictions.between("activedate", d1, d2)).addOrder(Order.asc("isscheduled"))
                .addOrder(Order.asc("activedate"))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
        return groups;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date getLastestActiveDate() {
        Date lastestDate = (Date) getSession().createCriteria(entityClass).setProjection(Projections.max("activedate"))
                .uniqueResult();
        return lastestDate;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Gamemixgroup> getLastestGameMixGroups() {
        Date d = DateUtils.toDateDB(DateUtils.getDBDateTime());
        List<Gamemixgroup> gmg = getSession().createCriteria(Gamemixgroup.class)
                .add(Restrictions.eq("status", Constants.STATUS_ACTIVE)).add(Restrictions.eq("isscheduled", true))
                .add(Restrictions.lt("activedate", d)).addOrder(Order.desc("activedate")).setMaxResults(1)
                .setCacheable(true).list();
        return gmg;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Gamemixgroup> getGameMixGroupByDate(Integer gameMixGroupId, Date activeDate) {
        List<Gamemixgroup> gmg = new ArrayList<Gamemixgroup>();
        if (gameMixGroupId == null) {
            gmg = getSession().createCriteria(Gamemixgroup.class).add(Restrictions.eq("activedate", activeDate))
                    .add(Restrictions.eq("status", Constants.STATUS_ACTIVE)).add(Restrictions.eq("isscheduled", true))
                    .list();
        } else {
            gmg = getSession().createCriteria(Gamemixgroup.class)
                    .add(Restrictions.ne("gamemixgroupid", gameMixGroupId))
                    .add(Restrictions.eq("activedate", activeDate))
                    .add(Restrictions.eq("status", Constants.STATUS_ACTIVE)).add(Restrictions.eq("isscheduled", true))
                    .list();
        }

        return gmg;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Gamemixgroup getCurrentGameMixGroup() {
        Gamemixgroup currentGamemixGroup = (Gamemixgroup) getSession().createCriteria(Gamemixgroup.class)
                .createAlias("gamemixes", "gamemixes")
                .createAlias("gamemixes.gamemixelements", "gamemixelements")
                .createAlias("gamemixelements.game", "game")
                .setFetchMode("gamemixes", FetchMode.SELECT)
                .add(Restrictions.eq("status", Constants.STATUS_ACTIVE))
                .add(Restrictions.eq("isscheduled", true))
                .addOrder(Order.desc("activedate"))
                .setMaxResults(1)
                .setCacheable(true)
                .uniqueResult();
        return currentGamemixGroup;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Gamemixgroup> getDayGameMixGroups() {
        Calendar today = Calendar.getInstance();
        Calendar yesterday = (Calendar) today.clone();
        yesterday.add(Calendar.DAY_OF_MONTH, -2);
        Calendar tomorrow = (Calendar) today.clone();
        tomorrow.add(Calendar.DAY_OF_MONTH, 2);

        String last = DateUtils.getDBDate(yesterday.getTime());
        String next = DateUtils.getDBDate(tomorrow.getTime());
        List<Gamemixgroup> listGmg = getSession()
                .createCriteria(Gamemixgroup.class)
                .add(Restrictions.eq("status", "Active"))
                .add(Restrictions.eq("isscheduled", true))
                .add(Restrictions.between("activedate", DateUtils.toDateDB(last + " 00:00:00"),
                        DateUtils.toDateDB(next + " 23:59:59"))).addOrder(Order.asc("activedate")).setCacheable(true)
                .list();

        return listGmg;
    }
}
