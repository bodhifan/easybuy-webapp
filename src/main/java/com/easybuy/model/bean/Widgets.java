package com.easybuy.model.bean;
/* Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.*/

import java.net.URI;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.glassfish.jersey.linking.InjectLink;

import com.easybuy.resources.WidgetsResource;

import lombok.Getter;
import lombok.Setter;

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
public class Widgets
{
    @XmlTransient
    int id;
    public Widgets(int id)
    {
       this.id = id;
    }
    
    @XmlElement
    @InjectLink(value="widgets/${instance.id}")
    @Getter @Setter URI u;
}
