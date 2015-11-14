package com.easybuy.config;
/* Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.*/

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;

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
public class MarshallingFeature implements Feature 
{

    @Override
    public boolean configure(FeatureContext context)
    {
        context.register(CustomJsonProvider.class, MessageBodyReader.class, MessageBodyWriter.class);
        return true;
    }

}
