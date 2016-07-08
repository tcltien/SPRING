/*
 * ScorecardController.java
 * 
 * Copyright 2016 DIRECTV, Inc.
 * An Unpublished Work.  All Rights Reserved.
 *
 * DIRECTV PROPRIETARY:  The information contained in or disclosed by this
 * document is considered proprietary by DIRECTV, Inc.  This document and/or the
 * information contained therein shall not be duplicated nor disclosed in whole
 * or in part without the specific written permission of DIRECTV, Inc.
 */
package com.directv.sds.nfl.web.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.directv.sds.common.Constants;
import com.directv.sds.common.controller.BaseController;
import com.directv.sds.common.util.SdsUtils;
import com.directv.sds.nfl.service.NflMicroService;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Team statistics.
 *
 * @author thoivt
 */
@Controller(value = "nflScorecardController")
@RequestMapping("/nfl/scorecard")
@SuppressWarnings("unchecked")
public class ScorecardController extends BaseController {
    static Logger log = Logger.getLogger(ScorecardController.class);

    @Autowired
    private NflMicroService nflMicroService;

    @RequestMapping(value = "/scores", method = RequestMethod.GET)
    public ModelAndView score() throws JsonProcessingException {
        log.info("Entering NFL Scorecard - Scores");
        Constants.DATE_FORMATTER.setTimeZone(Constants.TZ_LOS_ANGELES);

        ModelAndView view = new ModelAndView("nfl/scorecard/scores");
        Calendar cal = GregorianCalendar.getInstance(Constants.TZ_LOS_ANGELES);
        Object sportData = nflMicroService.getScoreboardData("date=" + Constants.DATE_FORMATTER.format(cal.getTime()));

        byte[] data = mapper.writeValueAsBytes(sportData);
        view.addObject("sportData", encoder.encodeToString(data));
        return view;
    }

    @RequestMapping(value = "/standings", method = RequestMethod.GET)
    public ModelAndView standings() throws JsonProcessingException {
        log.info("Entering NFL Scorecard - Standings");
        ModelAndView view = new ModelAndView("nfl/scorecard/standings");
        Calendar c = GregorianCalendar.getInstance(Constants.TZ_LOS_ANGELES);
        String nflSeason = SdsUtils.getNflSeason(c.getTime());
        Object sortedConferenceStandings = nflMicroService.getStandingsData(nflSeason);
        view.addObject("standingsData", encoder.encodeToString(mapper.writeValueAsBytes(sortedConferenceStandings)));
        return view;
    }

    @RequestMapping(value = "/stats", method = RequestMethod.GET)
    public String stats() {
        log.info("Entering Scorecard - Stats");
        return "nfl/scorecard/stats";
    }

    /**
     * 
     * Get schedule for 1 week starting from current date.
     *
     * @return
     * @throws ParseException
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public ModelAndView schedule() throws ParseException, JsonProcessingException {
        log.info("Entering NBA Scorecard - Schedule");
        ModelAndView view = new ModelAndView("nfl/scorecard/schedule");

        Constants.DATE_FORMATTER.setTimeZone(Constants.TZ_LOS_ANGELES);
        Calendar c = GregorianCalendar.getInstance(Constants.TZ_LOS_ANGELES);
        String year = String.valueOf(c.get(Calendar.YEAR));
        List<LinkedHashMap<String, Object>> scoreboardData = (List<LinkedHashMap<String, Object>>) nflMicroService
                .getScoreboardData("year=" + year);
        Map<String, List<LinkedHashMap<String, Object>>> sortedScoreboardData = sortScoreboardData(scoreboardData);

        view.addObject("scoreboardData", encoder.encodeToString(mapper.writeValueAsBytes(sortedScoreboardData)));
        view.addObject("year", year);
        view.addObject("listWeek", encoder.encodeToString(mapper.writeValueAsBytes(nflMicroService.getWeeks(year))));
        return view;
    }

    /**
     * 
     * Get schedule with a given date.
     *
     * @param startDate
     * @return
     * @throws ParseException
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "/schedule", method = RequestMethod.POST)
    public @ResponseBody Object ajaxSchedule(@RequestParam(value = "year", required = true) String year)
            throws ParseException, JsonProcessingException {
        log.info("NBA Scorecard - Get Schedule");

        List<LinkedHashMap<String, Object>> scoreboardData = (List<LinkedHashMap<String, Object>>) nflMicroService
                .getScoreboardData("year=" + year);
        Map<String, List<LinkedHashMap<String, Object>>> sortedScoreboardData = sortScoreboardData(scoreboardData);
        return encoder.encodeToString(mapper.writeValueAsBytes(sortedScoreboardData));
    }

    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    public ModelAndView teams() throws JsonProcessingException {
        log.info("Entering NFL Scorecard - Teams");
        ModelAndView view = new ModelAndView("nfl/scorecard/teams");
        Map<String, Object> teams = nflMicroService.getTeams();
        view.addObject("teams", encoder.encodeToString(mapper.writeValueAsBytes(teams)));
        return view;
    }

    @RequestMapping(value = "/teams/roster", method = RequestMethod.GET)
    public String teamsRoster() {
        log.info("Entering Scorecard - Team Roster");
        return "nfl/scorecard/teams/roster";
    }

    /**
     * 
     * Team schedule for current year.
     *
     * @param teamName
     * @return
     * @throws JsonProcessingException
     * @throws ParseException
     */
    @RequestMapping(value = "/teams/schedule", method = RequestMethod.GET)
    public ModelAndView teamsSchedule(@RequestParam("teamName") String teamName) throws JsonProcessingException,
            ParseException {
        log.info("Entering NFL Scorecard - Teams/schedule");
        ModelAndView view = new ModelAndView("nfl/scorecard/teams/schedule");
        Calendar c = GregorianCalendar.getInstance(Constants.TZ_LOS_ANGELES);
        String year = String.valueOf(c.get(Calendar.YEAR));
        List<LinkedHashMap<String, Object>> scoreboardData = (List<LinkedHashMap<String, Object>>) nflMicroService
                .getScoreboardData("teamName=" + teamName, "year=" + year);
        Map<String, List<LinkedHashMap<String, Object>>> sortedScoreboardData = sortScoreboardData(scoreboardData);
        Map<String, Object> teams = nflMicroService.getTeams();
        view.addObject("sportData", encoder.encodeToString(mapper.writeValueAsBytes(sortedScoreboardData)));
        view.addObject("teams", encoder.encodeToString(mapper.writeValueAsBytes(teams)));
        return view;
    }

    /**
     * 
     * Team schedule for a selected year.
     *
     * @param teamName
     * @param year
     * @return
     * @throws JsonProcessingException
     * @throws ParseException
     */
    @RequestMapping(value = "/teams/schedule", method = RequestMethod.POST)
    public @ResponseBody Object ajaxTeamsSchedule(@RequestParam("teamName") String teamName,
            @RequestParam(value = "year", required = false) String year) throws JsonProcessingException, ParseException {
        log.info("NBA Scorecard - Get Teams/schedule");
        Calendar c = GregorianCalendar.getInstance(Constants.TZ_LOS_ANGELES);
        if (StringUtils.isBlank(year)) {
            year = String.valueOf(c.get(Calendar.YEAR));
        }
        List<LinkedHashMap<String, Object>> listTmp = (List<LinkedHashMap<String, Object>>) nflMicroService
                .getScoreboardData("teamName=" + teamName, "year=" + year);
        Map<String, List<LinkedHashMap<String, Object>>> sortedScoreboardData = sortScoreboardData(listTmp);
        Map<String, Object> teams = nflMicroService.getTeams();
        Map<String, Object> data = new TreeMap<String, Object>();
        data.put("sportData", sortedScoreboardData);
        data.put("teams", teams);

        return encoder.encodeToString(mapper.writeValueAsBytes(data));
    }

    @RequestMapping(value = "/teams/stats", method = RequestMethod.GET)
    public String teamsStats() {
        log.info("Entering Scorecard - Team Stats");
        return "nfl/scorecard/teams/stats";
    }

    /**
     * To sort data by date.
     *
     * @param scoreboardData
     * @return
     * @throws ParseException
     */
    private Map<String, List<LinkedHashMap<String, Object>>> sortScoreboardData(
            List<LinkedHashMap<String, Object>> scoreboardData) throws ParseException {
        Map<String, List<LinkedHashMap<String, Object>>> sortedScoreboardData = new TreeMap<String, List<LinkedHashMap<String, Object>>>();
        Constants.DATE_FORMATTER.setTimeZone(Constants.TZ_LOS_ANGELES);
        if (!CollectionUtils.isEmpty(scoreboardData)) {
            for (LinkedHashMap<String, Object> data : scoreboardData) {
                Date gameTime = Constants.DATE_FORMATTER.parse((String) data.get("gameTime"));
                putObjects(sortedScoreboardData, Constants.DATE_FORMATTER.format(gameTime), data);
            }
        }
        return sortedScoreboardData;
    }

    /**
     * 
     * Simulate multimap.
     *
     * @param map
     * @param key
     * @param value
     */
    private void putObjects(Map<String, List<LinkedHashMap<String, Object>>> map, String key,
            LinkedHashMap<String, Object> value) {
        List<LinkedHashMap<String, Object>> myClassList = map.get(key);
        if (myClassList == null) {
            myClassList = new ArrayList<LinkedHashMap<String, Object>>();
            map.put(key, myClassList);
        }
        myClassList.add(value);

    }
}
