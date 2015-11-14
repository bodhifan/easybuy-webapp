package com.easybuy.services;
/* Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.*/

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.easybuy.model.bean.Classier;
import com.easybuy.model.bean.Productor;
import com.easybuy.model.data.ClasserEntity;
import com.easybuy.model.data.ProductorEntity;
import com.easybuy.utily.ConvertUtilty;

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
public class ProductorDaoImp implements ProductorDao
{

    @Override
    public int createProductor(String pName, Classier classer, double price,
            String desc, Date createDate)
    {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA_EASYBUY");
        EntityManager entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();
               
        ProductorEntity entity = new ProductorEntity();
       // entity.setpId(101);
        entity.setName(pName);
        entity.setPrice(price);
        entity.setDescrition(desc);  
        entity.setClasser(entityManager.find(ClasserEntity.class, classer.getId()));        
        entityManager.persist(entity);
        
        
        entityManager.getTransaction().commit();
        entityManager.close();
        
        emFactory.close();
        
        return entity.getId();
    }

    @Override
    public ProductorEntity getProductor(String name)
    {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA_EASYBUY");
        EntityManager entityManager = emFactory.createEntityManager();        
        TypedQuery<ProductorEntity> query =  entityManager.createNamedQuery("Productor.findByName",ProductorEntity.class);
        query.setParameter("name", name);
        List<ProductorEntity> rtn = query.getResultList();
        entityManager.close();
        
        emFactory.close();
        return rtn.get(0);
    }

    @Override
    public List<ProductorEntity> getAllProductor()
    {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA_EASYBUY");
        EntityManager entityManager = emFactory.createEntityManager();        
        TypedQuery<ProductorEntity> query =  entityManager.createNamedQuery("Productor.findAll",ProductorEntity.class);
        List<ProductorEntity> rtn = query.getResultList();
        entityManager.close();
        emFactory.close();
        return rtn;
    }

    @Override
    public void deleteProductor(int pId)
    {
        // TODO Auto-generated method stub
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA_EASYBUY");
        EntityManager entityManager = emFactory.createEntityManager();              
        entityManager.getTransaction().begin();
        ProductorEntity entity =  entityManager.find(ProductorEntity.class, pId);
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        emFactory.close();
    }
    
    @Override
    public ProductorEntity getProductor(int pId)
    {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA_EASYBUY");
        EntityManager entityManager = emFactory.createEntityManager();        
       ProductorEntity entity =  entityManager.find(ProductorEntity.class, pId);
       entityManager.close();
       emFactory.close();
       return entity;
    }



}
