package com.easybuy.model.bean;
/* Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.*/
import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.glassfish.jersey.linking.Binding;
import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLink.Style;

import com.easybuy.resources.ClassierResource;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
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
@Data
@JsonPropertyOrder(alphabetic = true,value = {"id","name"})  
public class Productor
{
    
    private int id; // 商品序列号
    
    private String name; // 商品名称 
    
    @JsonProperty("productorClassier")
    @InjectLink(resource=ClassierResource.class,method="get",
            style=Style.ABSOLUTE,
            bindings = @Binding(name = "id", value = "${instance.clser.id}"),
            rel = "self")
    @XmlJavaTypeAdapter(Link.JaxbAdapter.class)
    private Link classer;
    
    @JsonIgnore
    private Classier clser;// 商品类别
    private  double price; // 商品价格
    private  String descrition;// 商品描述
    
    
    
}
