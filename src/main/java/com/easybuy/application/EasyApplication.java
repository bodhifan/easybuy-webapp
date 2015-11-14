package com.easybuy.application;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

/* Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.*/

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
 *   bofan     2015年11月2日 - Creation
 *
 */
public class EasyApplication extends ResourceConfig
{
    public EasyApplication(){
        packages("com.easybuy.resources");
        register(JacksonJaxbJsonProvider.class);
    }
}
