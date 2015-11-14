package com.easybuy.model.bean;
/* Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.*/

import java.net.URI;

import javax.persistence.ManyToOne;
import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.glassfish.jersey.linking.Binding;
import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLink.Style;

import com.easybuy.model.data.ClasserEntity;
import com.easybuy.resources.ClassierResource;
import com.easybuy.services.ProductorDao;
import com.easybuy.services.ProductorDaoImp;

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
@XmlRootElement
@Data
public class Productor
{
    public Productor()
    {
        
    }
    public Productor(int id)
    {
        this.pId = id;
        ProductorDao productorDao = new ProductorDaoImp();
        Productor productor = productorDao.getProductor(id);
        this.pName = productor.pName;
        this.classer = productor.classer;
        this.price = productor.price;
        this.descrition = productor.descrition;
    }
    private int pId; // 商品序列号
    private String pName; // 商品名称 
    
    @com.fasterxml.jackson.annotation.JsonProperty("productClassier")
    @InjectLink(resource=ClassierResource.class,method="get",
            style=Style.ABSOLUTE,
            bindings = @Binding(name = "id", value = "${instance.clser.id}"),
            rel = "self")
    @XmlJavaTypeAdapter(Link.JaxbAdapter.class)
    private Link classer;
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    private Classier clser;// 商品类别
    private double price; // 商品价格
    private String descrition;// 商品描述
}
