package com.easybuy.exceptions;
/* Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.*/

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.ws.soap.AddressingFeature.Responses;

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
public class NotFoundException extends WebApplicationException 
{

    public NotFoundException() {
        super(Response.status(Status.NOT_FOUND).build());
      }
     
    public NotFoundException(String message) {
        super(Response.status(Status.NOT_FOUND).
        entity(message).type("text/plain").build());
      }

}
