package com.easybuy.config;
/* Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.*/

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.easybuy.model.bean.Classier;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.module.SimpleModule;

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
 *   bofan     2015年11月11日 - Creation
 *
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class CustomJasonContextResovler implements ContextResolver<ObjectMapper>
{
    /**
    Default Object Mapper will be used for other POJOs
    */
    ObjectMapper defaultObjectMapper;

    /**
    user Object Mapper will be used for User POJO ONLY.
    */
    ObjectMapper userObjectMapper;

    /**
    MyObjectMapperProvider() constructor initializes the
    defaultObjectMapper and userObjectMapper.
    */
//    public JacksonContextResolver() {
//        defaultObjectMapper = createDefaultMapper();
//        userObjectMapper = createUserObjectMapper();
//    }

    public CustomJasonContextResovler() throws Exception
    {
        System.out.println("############new ObjectMapperResolver()");
        this.defaultObjectMapper = new ObjectMapper();
        defaultObjectMapper.setSerializationInclusion(Include.ALWAYS);
        
        SimpleModule simpleModule = new SimpleModule(getClass().getName(), new Version(1, 0, 0, null));
        simpleModule.addSerializer(Link.class, new LinkSerializer());
        defaultObjectMapper.registerModule(simpleModule);
        
        DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        dFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        defaultObjectMapper.setDateFormat(dFormat);
        
        AnnotationIntrospector primary = new JacksonAnnotationIntrospector();
        AnnotationIntrospector secondary = new com.easybuy.deploy.JaxbAnnotationIntrospector();
        
        AnnotationIntrospector pAnnotationIntrospector =  new AnnotationIntrospector.Pair(primary, secondary);
        
        SerializationConfig sConfig = defaultObjectMapper.getSerializationConfig().withInsertedAnnotationIntrospector(pAnnotationIntrospector);
        sConfig.withSerializationInclusion(Include.NON_NULL);
        
    } 
//    private static ObjectMapper createDefaultMapper() {
//        ObjectMapper result = new ObjectMapper();
//        result.configure(Feature.INDENT_OUTPUT, true);
//
//        return result;
//    }
//    private static ObjectMapper createUserObjectMapper() {
//        
//        Pair combinedIntrospector =createJaxbJacksonAnnotationIntrospector();
//        ObjectMapper result = new ObjectMapper();
//        result.configure(SerializationConfig.Feature.WRAP_ROOT_VALUE, true);
//        result.configure(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE, true);
//        result.setDeserializationConfig(result.getDeserializationConfig().withAnnotationIntrospector(combinedIntrospector));
//        result.setSerializationConfig(result.getSerializationConfig().withAnnotationIntrospector(combinedIntrospector));
//
//        return result;
//    }
//    
//    private static Pair createJaxbJacksonAnnotationIntrospector() {
//
//        AnnotationIntrospector jaxbIntrospector = new JaxbAnnotationIntrospector();
//        AnnotationIntrospector jacksonIntrospector = new JacksonAnnotationIntrospector();
//        return new AnnotationIntrospector.Pair(jacksonIntrospector, jaxbIntrospector);
//    }
    
    @Override
    public ObjectMapper getContext(Class<?> type)
    {
        System.out.println("#######ObjectMapperResolver.getContext(...)");
        return defaultObjectMapper;
//        if (type == Classier.class) {
//            return userObjectMapper;
//            } else {
//            return defaultObjectMapper;
//            }
    }

}
