/*
 * CustomExceptionHandler.java
 * 
 * Copyright 2016 DIRECTV, Inc.
 * An Unpublished Work.  All Rights Reserved.
 *
 * DIRECTV PROPRIETARY:  The information contained in or disclosed by this
 * document is considered proprietary by DIRECTV, Inc.  This document and/or the
 * information contained therein shall not be duplicated nor disclosed in whole
 * or in part without the specific written permission of DIRECTV, Inc.
 */
package com.directv.sds.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * This class handles the exception from web controller.
 *
 * @author thoivt
 */
@ControllerAdvice
public class CustomExceptionHandler {

    private final static Logger log = LoggerFactory.getLogger(CustomExceptionHandler.class);

    /**
     * 
     * Handle the generic exception.
     *
     * @param ne
     * @return
     */
    @ExceptionHandler
    public @ResponseBody String exceptionHandler(Exception e) {

        log.error(e.getLocalizedMessage());
        return "error";
    }
}
