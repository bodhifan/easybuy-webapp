package com.easybuy.resources;
/* Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.*/

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.easybuy.model.bean.Widgets;

/*
 * DESCRIPTION
 *     TODO
 *
 * PRIVATE CLASSES
 *     NONE
 *
 * NOTES
 *    <other useful comments, qualifications, etc.>
 *
 * MODIFIED    (MM/DD/YY)
 *   bofan     2015年11月6日 - Creation
 *
 */
@Path("widgets")
public class WidgetsResource
{
    @GET
    public Widgets get() {
        return new Widgets(1);
    }
}
