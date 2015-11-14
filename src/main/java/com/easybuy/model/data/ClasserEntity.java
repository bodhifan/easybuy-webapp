package com.easybuy.model.data;
/* Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.*/

import java.net.URI;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.glassfish.jersey.linking.InjectLink;

import com.easybuy.resources.ClassierResource;

/*
 * DESCRIPTION
 *     商品类别
 *
 * PRIVATE CLASSES
 *     NONE
 *
 * NOTES
 *    <other useful comments, qualifications, etc.>
 *
 * MODIFIED    (MM/DD/YY)
 *   bofan     2015年10月31日 - Creation
 *
 */
@Entity
@Table(name="classier")

public class ClasserEntity
{
    
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    
    private int id;// 类别id
    private String name; // 类别名称
    private String descrition; // 描述
    public String getDescrition()
    {
        return descrition;
    }
    public void setDescrition(String descrition)
    {
        this.descrition = descrition;
    }
    public ClasserEntity()
    {
        super();
    }
    public ClasserEntity(int cId, String name, String desc)
    {
        super();
        this.id = cId;
        this.name = name;
        this.descrition = desc;
    }
    public int getId()
    {
        return id;
    }
    public void setId(int cId)
    {
        this.id = cId;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
}
