package com.easybuy.services;
/* Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.*/

import com.easybuy.model.bean.Classier;
import com.easybuy.model.data.ClasserEntity;

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
public interface ClassierDao
{

    // add
    int Create(String name,String description);
    boolean Update(int id,String name);
    boolean Delete(int id);
    Classier Get(int id);
}
