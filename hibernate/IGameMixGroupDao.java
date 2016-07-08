/*
 * IGameMixGroupDao.java
 * 
 * Copyright 2015 DIRECTV, Inc.
 * An Unpublished Work.  All Rights Reserved.
 *
 * DIRECTV PROPRIETARY:  The information contained in or disclosed by this
 * document is considered proprietary by DIRECTV, Inc.  This document and/or the
 * information contained therein shall not be duplicated nor disclosed in whole
 * or in part without the specific written permission of DIRECTV, Inc.
 */
package com.directv.mlb.persistence.dao;

import java.util.Date;
import java.util.List;

import com.directv.mlb.pojo.Gamemixgroup;

/**
 * IGameMixGroupDao Interface defines methods that would be implemented by GameMixGroupDaoImpl
 * 
 * @author ninhhp
 */
public interface IGameMixGroupDao extends IGenericDao<Gamemixgroup> {

    /**
     * This method returns all active GameMixGroup objects from the database for the given date.
     * 
     * @param date
     *            GameDetail date.
     * 
     * @return GameMixGroup object array.
     */
    List<Gamemixgroup> getActiveGameMixGroups(String date);

    /**
     * This method returns lastest Date of game mix
     * 
     * 
     * @return the lastest Date
     */
    Date getLastestActiveDate();

    /**
     * set latest game mix groups
     * 
     * @return List<Gamemixgroupd>
     */
    List<Gamemixgroup> getLastestGameMixGroups();

    /**
     * 
     * Get game mix group to check duplicate Time
     * 
     * @param gameMixGroup
     * @param activeDate
     * @return
     */
    List<Gamemixgroup> getGameMixGroupByDate(Integer gameMixGroupId, Date activeDate);

    /**
     * Get Current gamemix group
     * 
     * @return
     */
    Gamemixgroup getCurrentGameMixGroup();

    /**
     * Returns list of active and scheduled GameMixGroups for today, or null if exception.
     * 
     * @return
     */
    public List<Gamemixgroup> getDayGameMixGroups();

}
