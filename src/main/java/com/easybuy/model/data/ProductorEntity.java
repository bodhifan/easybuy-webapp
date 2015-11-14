package com.easybuy.model.data;

import java.io.Serializable;
import java.lang.annotation.Target;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

/* Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.*/

/*
 * DESCRIPTION
 *     商品
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
@Table(name="productor")
@XmlRootElement(name="product")
@Data
@NamedQueries({
    @NamedQuery(name="Productor.findAll",
                query="select p from ProductorEntity p"),
    @NamedQuery(name="Productor.findByName",
                query="select p from ProductorEntity p where p.name = :name")
})
public class ProductorEntity implements Serializable
{
    @Override
    public String toString()
    {
        return String.format("PID：%d NAME:%s Price:%f Description: %s", id,name,price,descrition);       
    }
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private int id; // 商品序列号
    private String name; // 商品名称    
    
    @ManyToOne
    private ClasserEntity classer;// 商品类别
    private double price; // 商品价格
    private String descrition;// 商品描述
   // private Date createDate; // 创建日期
   
}
