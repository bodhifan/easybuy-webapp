package com.easybuy.model.bean;
/* Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.*/

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


import org.glassfish.jersey.linking.Binding;
import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLinks;
import org.glassfish.jersey.linking.InjectLink.Style;

import com.easybuy.model.data.ItemsModel;
import com.easybuy.model.data.ProductorEntity;
import com.easybuy.resources.ItemsResource;
import com.easybuy.resources.ProductorResource;
import com.easybuy.resources.ProductorsResource;
import com.easybuy.services.ProductorDao;
import com.easybuy.services.ProductorDaoImp;
import com.easybuy.utily.ConvertUtilty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
 *   bofan     2015年11月13日 - Creation
 *
 */
//@InjectLinks({
//        @InjectLink(
//                resource = ProductorsResource.class,
//                style = Style.ABSOLUTE,
//                method = "query",
//                condition = "${instance.offset + instance.limit < instance.modelLimit}",
//                bindings = {
//                        @Binding(name = "offset", value = "${instance.offset + instance.limit}"),
//                        @Binding(name = "limit", value = "${instance.limit}")
//                },
//                rel = "next"
//        ),
//        @InjectLink(
//                resource = ProductorsResource.class,
//                style = Style.ABSOLUTE,
//                method = "query",
//                condition = "${instance.offset - instance.limit >= 0}",
//                bindings = {
//                        @Binding(name = "offset", value = "${instance.offset - instance.limit}"),
//                        @Binding(name = "limit", value = "${instance.limit}")
//                },
//                rel = "prev"
//        )})
@Data
@JsonPropertyOrder(alphabetic = true,value = {"productors"})  
public class Productors {

    @JsonProperty("productors")
    private List<Productor> items;

    @JsonIgnore
    private int offset, limit;

    @JsonIgnore
    private ProductorDao productorModel;

    @InjectLink(
            resource = ProductorsResource.class,
            method = "query",
            style = Style.ABSOLUTE,
            bindings = {@Binding(name = "offset", value = "${instance.offset}"),
                    @Binding(name = "limit", value = "${instance.limit}")
            },
            rel = "self"
    )
    @XmlJavaTypeAdapter(Link.JaxbAdapter.class)
    @Getter Link self;

    @InjectLinks({
            @InjectLink(
                    resource = ProductorsResource.class,
                    style = Style.ABSOLUTE,
                    method = "query",
                    condition = "${instance.offset + instance.limit < instance.modelLimit}",
                    bindings = {
                            @Binding(name = "offset", value = "${instance.offset + instance.limit}"),
                            @Binding(name = "limit", value = "${instance.limit}")
                    },
                    rel = "next"
            ),
            @InjectLink(
                    resource = ProductorsResource.class,
                    style = Style.ABSOLUTE,
                    method = "query",
                    condition = "${instance.offset - instance.limit >= 0}",
                    bindings = {
                            @Binding(name = "offset", value = "${instance.offset - instance.limit}"),
                            @Binding(name = "limit", value = "${instance.limit}")
                    },
                    rel = "prev"
            )})
    @XmlElement(name = "link")
    @XmlElementWrapper(name = "links")
    @XmlJavaTypeAdapter(Link.JaxbAdapter.class)
    @Getter List<Link> links;

    public Productors() {
        offset = 0;
        limit = 10;
        productorModel = new ProductorDaoImp();
    }

    public Productors(int offset, int limit) {

        productorModel = new ProductorDaoImp();
        this.offset = offset;
        this.limit = limit;
        items = new ArrayList<>();
        List<ProductorEntity> entities = productorModel.getAllProductor();
        for (int i = offset; i < (offset + limit) && i < entities.size(); i++) {
            items.add(ConvertUtilty.convertToProductor(entities.get(i)));
        }

    }
    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    @JsonIgnore
    public int getModelLimit() {
        return productorModel.getAllProductor().size();
    }
    
    public Productor getProductor(int id)
    {
        ProductorEntity entity = productorModel.getProductor(id);
        return ConvertUtilty.convertToProductor(entity);
    }
}

