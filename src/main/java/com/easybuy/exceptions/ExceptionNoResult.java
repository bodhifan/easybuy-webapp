package com.easybuy.exceptions;
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
 *   bofan     2015年11月13日 - Creation
 *
 */
public class ExceptionNoResult extends Exception
{

    @Override
    public String getMessage()
    {
        // TODO Auto-generated method stub
        return "No result get " + super.getMessage();
    }

}
