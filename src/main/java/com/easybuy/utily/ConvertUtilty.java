package com.easybuy.utily;
/* Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.*/

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
        Productor productor = new Productor();
        productor.setPId(entity.getId());
        productor.setPName(entity.getName());
        productor.setPrice(entity.getPrice());
        productor.setDescrition(entity.getDescrition());
        productor.setClser(convertToClassier(entity.getClasser()));
        return productor;
    } 
    public static Classier convertToClassier(ClasserEntity entity)
    {
        Classier classier = new Classier();
        classier.setId(entity.getId());
        classier.setName(entity.getName());
        classier.setDescrition(entity.getDescrition());
        return classier;
    } 
    
}
