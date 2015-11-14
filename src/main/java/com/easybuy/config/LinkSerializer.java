package com.easybuy.config;
/* Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.*/

import java.io.IOException;

import javax.ws.rs.core.Link;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;


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
public class LinkSerializer extends JsonSerializer<Link>
{

    @Override
    public void serialize(Link link, JsonGenerator jg,
            SerializerProvider arg2) throws IOException, JsonProcessingException
    {
        jg.writeStartObject();
        jg.writeStringField("rel", link.getRel());
        jg.writeStringField("href", link.getUri().toString());
        jg.writeEndObject();
        
    }

    
}
