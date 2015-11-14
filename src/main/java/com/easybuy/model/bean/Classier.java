package com.easybuy.model.bean;
/* Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.*/

import java.net.URI;
import java.net.URL;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.glassfish.jersey.linking.Binding;
import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLink.Style;

import com.easybuy.resources.ClassierResource;

import lombok.Data;
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
@XmlRootElement
public class Classier
{
    @InjectLink(resource=ClassierResource.class,method="get",
            bindings = @Binding(name = "id", value = "${instance.id}"),
            rel = "self")
    private @Getter @Setter String canonicalLink;
    private @Getter @Setter int id;// 类别id
    
    private @Getter @Setter String name; // 类别名称
    
    private @Getter @ Setter String  descrition; // 描述
    
}
