package com.easybuy.services;
/* Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.*/

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.easybuy.model.bean.Classier;
import com.easybuy.model.data.ClasserEntity;
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
 *   bofan     2015年11月5日 - Creation
 *
 */
public class ClassierDaoImp implements ClassierDao
{

    EntityManager entityManager;
    public ClassierDaoImp()
    {
        
    }
    
    @Override
    public int Create(String name,String desc)
    {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA_EASYBUY");
        entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();
        ClasserEntity entity = new ClasserEntity();
        entity.setName(name);
        entity.setDescrition(desc);
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        emFactory.close();
        return entity.getId();
    }

    @Override
    public boolean Update(int id, String name)
    {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA_EASYBUY");
        entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();
        ClasserEntity entity = entityManager.find(ClasserEntity.class,id);
        entity.setName(name);
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        emFactory.close();
        
        return true;
    }

    @Override
    public boolean Delete(int id)
    {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA_EASYBUY");
        entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();
        ClasserEntity entity = entityManager.find(ClasserEntity.class,id);
        entityManager.remove(entity);
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        emFactory.close();
        
        return true;
    }
    
    @Override
    public Classier Get(int id)
    {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA_EASYBUY");
        entityManager = emFactory.createEntityManager();
        ClasserEntity entity = entityManager.find(ClasserEntity.class,id);
        entityManager.close();
        emFactory.close();
        
        return ConvertUtilty.convertToClassier(entity);
    }


}
