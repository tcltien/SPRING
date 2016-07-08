/*
 * CellLabelStatus.java
 * 
 * Copyright 2015 DIRECTV, Inc.
 * An Unpublished Work.  All Rights Reserved.
 *
 * DIRECTV PROPRIETARY:  The information contained in or disclosed by this
 * document is considered proprietary by DIRECTV, Inc.  This document and/or the
 * information contained therein shall not be duplicated nor disclosed in whole
 * or in part without the specific written permission of DIRECTV, Inc.
 */
package com.directv.mlb.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Define the list of status's label for cell.
 *
 * @author thoivt
 */
public enum CellLabelStatus {
    PREGAME("Pregame", "Pregame", "PREGAME"), PREGAME_PPD_RAIN("PregamePPDRain", "Pregame - Rain Delay", "RAIN"),
    		PREGAME_PPD("PregameDelay", "Pregame - Delay", "DELAY"), PREGAME_CUSTOM("PregameCustom", "Pregame - Custom", "PRECUSTOM") , 
            RAINOUT("PregameRainout", "Pregame - Rainout", "RAINOUT"), CANCELLED("PregameCancelled", "Pregame - Cancelled", "CANCELLED"), 
            LIVE("Live", "Live", "LIVE"), LIVE_RAIN("LiveRain", "Live - Rain", "RAIN"), LIVE_CUSTOM("LiveCustom", "Live - Custom", "LIVECUSTOM") ,
            LIVE_PPD("LiveDelay", "Live - Delayed", "PPD"), LIVE_NO_VIDEO("LiveNoVideo", "Live - No Video", "NO VIDEO"),
            LIVE_REVIEW("LiveReview", "Live - Review", "REVIEW"), FINAL("Final", "Final", "FINAL"), 
            FINAL_RAINOUT("FinalRainout", "Final - Rainout", "RAINOUT"), FINAL_CANCELLED("FinalCancelled", "Final - Postponed","CANCELLED"), 
            FINAL_SUSPENDED("FinalSuspended", "Final - Suspended", "SUSP"), ERROR("Error", "Error","TROUBLE"), 
            OFF("Off", "Off", "OFF");

    private final String value;

    private final String label;

    private final String shortLabel;

    /**
     * 
     * Constructor to init game status.
     *
     * @param value
     */
    private CellLabelStatus(String value, String label, String shortLabel) {
        this.value = value;
        this.label = label;
        this.shortLabel = shortLabel;
    }

    /**
     * 
     * Get value
     *
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * Get label
     *
     * @return label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Get shortLabel
     *
     * @return shortLabel
     */
    public String getShortLabel() {
        return shortLabel;
    }

    /**
     * 
     * Return all values of cell label status.
     *
     * @return
     */
    public static List<String> getAllValues() {
        List<String> allValues = new ArrayList<String>();
        List<CellLabelStatus> lst = Arrays.asList(CellLabelStatus.values());
        for (CellLabelStatus cellLabelStatus : lst) {
            allValues.add(cellLabelStatus.getValue());
        }
        return allValues;
    }

    /**
     * 
     * Return all labels of cell label status.
     *
     * @return
     */
    public static List<String> getAllLabels() {
        List<String> allLabels = new ArrayList<String>();
        List<CellLabelStatus> lst = Arrays.asList(CellLabelStatus.values());
        for (CellLabelStatus cellLabelStatus : lst) {
            allLabels.add(cellLabelStatus.getLabel());
        }
        return allLabels;
    }

    /**
     * 
     * Return all labels of cell label status.
     *
     * @return
     */
    public static List<String> getAllShortLabels() {
        List<String> allLabels = new ArrayList<String>();
        List<CellLabelStatus> lst = Arrays.asList(CellLabelStatus.values());
        for (CellLabelStatus cellLabelStatus : lst) {
            allLabels.add(cellLabelStatus.getShortLabel());
        }
        return allLabels;
    }

    /**
     * 
     * Get enum by value.
     *
     * @param value
     * @return
     */
    public static CellLabelStatus getByValue(String value) {
        for (CellLabelStatus cls : CellLabelStatus.values()) {
            if (cls.getValue().equals(value))
                return cls;
        }
        throw new IllegalArgumentException("The given value doesn't match any CellLabelStatus.");
    }

}
