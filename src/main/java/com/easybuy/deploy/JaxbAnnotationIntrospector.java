package com.easybuy.deploy;
/* Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.*/

import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.databind.introspect.AnnotatedMember;


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
 *   bofan     2015年11月11日 - Creation
 *
 */
public class JaxbAnnotationIntrospector extends com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector
{

    @Override
    public boolean hasIgnoreMarker(AnnotatedMember m)
    {
        return m.getAnnotation(XmlTransient.class) != null;
    }

}
