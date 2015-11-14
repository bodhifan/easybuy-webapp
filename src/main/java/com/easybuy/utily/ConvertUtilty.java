package com.easybuy.utily;
/* Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.*/

import java.util.ArrayList;
import java.util.List;

import com.easybuy.model.bean.Classier;
import com.easybuy.model.bean.Productor;
import com.easybuy.model.data.ClasserEntity;
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
 *   bofan     2015年11月6日 - Creation
 *
 */
public class ConvertUtilty
{

    public static Productor convertToProductor(ProductorEntity entity)
    {
        if (entity == null)
        {
            return null;
        }
        Productor productor = new Productor();
        productor.setId(entity.getId());
        productor.setName(entity.getName());
        productor.setPrice(entity.getPrice());
        productor.setDescrition(entity.getDescrition());
        productor.setClser(convertToClassier(entity.getClasser()));
        return productor;
    } 
    
    public static List<Productor> convertToProductors(List<ProductorEntity> entities)
    {
        if (entities == null)
        {
            return null;
        }
        List<Productor> productors = new ArrayList<>();
        for (ProductorEntity entity : entities)
        {
            Productor productor = new Productor();
            productor.setId(entity.getId());
            productor.setName(entity.getName());
            productor.setPrice(entity.getPrice());
            productor.setDescrition(entity.getDescrition());
            productor.setClser(convertToClassier(entity.getClasser()));
            productors.add(productor);
        }

        return productors;
    } 
    public static Classier convertToClassier(ClasserEntity entity)
    {
        if (entity == null)
        {
            return null;
            
        }
        Classier classier = new Classier();
        classier.setId(entity.getId());
        classier.setName(entity.getName());
        classier.setDescrition(entity.getDescrition());
        return classier;
    } 
    
}
