package com.easybuy.resources;
/* Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.*/

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.easybuy.model.bean.Classier;
import com.easybuy.model.data.ClasserEntity;
import com.easybuy.services.ClassierDaoImp;

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
 *   bofan     2015年11月5日 - Creation
 *
 */
@Path("classier/{id}")
public class ClassierResource
{
    @Context 
    UriInfo uriInfo;
    
    int id;
    public int getId()
    {
        return id;
    }
    @GET
    public Classier get(@PathParam("id") int clsId)
    {
       id = clsId;
       return new ClassierDaoImp().Get(151);
    }
}
