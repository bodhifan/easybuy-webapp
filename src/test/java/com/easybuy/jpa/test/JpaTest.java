package com.easybuy.jpa.test;
/* Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.*/

import java.util.Date;

import org.junit.Test;

import com.easybuy.model.data.ClasserEntity;
import com.easybuy.model.data.ProductorEntity;
import com.easybuy.services.ClassierDao;
import com.easybuy.services.ClassierDaoImp;
import com.easybuy.services.ProductorDao;
import com.easybuy.services.ProductorDaoImp;

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
public class JpaTest
{

    @Test
    public void CreateClassier()
    {
        ClassierDao dao = new ClassierDaoImp();
        int entity =  dao.Create("cls1", "the first classier of productors");
        System.out.println(entity);
    }
    
    @Test
    public void CreateProductor()
    {
        ProductorDao dao = new ProductorDaoImp();
        ClassierDao classierDao = new ClassierDaoImp();        
        int entity =  dao.createProductor("productor3", classierDao.Get(501), 783.34, "second product", new Date());
        System.out.println(entity);
    }
   
}
