package com.easybuy.config;
/* Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.*/

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

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
 *   bofan     2015年11月14日 - Creation
 *
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class CustomJsonProvider extends JacksonJaxbJsonProvider 
{
    private static ObjectMapper mapper = new ObjectMapper();
    static {
        try
        {
            mapper = new CustomJasonContextResovler().getContext(ObjectMapper.class);
            System.out.println("初始化...");
        }
        catch(Exception ex)
        {
            System.out.println("初始化...");
        }
     }
}
