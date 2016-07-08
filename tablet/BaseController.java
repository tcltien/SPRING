/*
 * BaseController.java
 * 
 * Copyright 2016 DIRECTV, Inc.
 * An Unpublished Work.  All Rights Reserved.
 *
 * DIRECTV PROPRIETARY:  The information contained in or disclosed by this
 * document is considered proprietary by DIRECTV, Inc.  This document and/or the
 * information contained therein shall not be duplicated nor disclosed in whole
 * or in part without the specific written permission of DIRECTV, Inc.
 */
package com.directv.sds.common.controller;

import java.util.Base64;
import java.util.Base64.Encoder;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Define a generic common controller.
 *
 * @author thoivt
 */
public abstract class BaseController {
    // Json Object mapper
    protected static ObjectMapper mapper = new ObjectMapper();

    // Base64 encoder
    protected static Encoder encoder = Base64.getEncoder();
}
