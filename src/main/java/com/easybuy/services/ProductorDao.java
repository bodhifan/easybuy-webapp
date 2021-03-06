package com.easybuy.services;
/* Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.*/

import java.util.Date;
import java.util.List;

import com.easybuy.model.bean.Classier;
import com.easybuy.model.data.ProductorEntity;

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
 *   bofan     2015年10月31日 - Creation
 *
 */
public interface ProductorDao
{
    int createProductor(String pName, Classier classer, double price,
            String desc, Date createDate);
    void deleteProductor(int pId);
    ProductorEntity getProductor(int pId);
    ProductorEntity getProductor(String name);
    List<ProductorEntity> getAllProductor();
}
