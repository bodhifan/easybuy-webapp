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
import com.easybuy.resources.ItemsResource;
import com.easybuy.resources.ProductorResource;
import com.easybuy.resources.ProductorsResource;
import com.easybuy.services.ProductorDaoImp;

import lombok.Getter;

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
@XmlRootElement(name = "items")
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
public class Productors {

    @XmlElement(name = "items")
    private List<Productor> items;

    @com.fasterxml.jackson.annotation.JsonIgnore
    private int offset, limit;

    @XmlTransient
    @com.fasterxml.jackson.annotation.JsonIgnore
    private List<Productor> itemsModel;

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
    @XmlElement(name = "link")
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
    }

    public Productors(ItemsModel itemsModel, int offset, int limit) {

        this.offset = offset;
        this.limit = limit;
        this.itemsModel = new ProductorDaoImp().getAllProductor();

        items = new ArrayList<>();
        for (int i = offset; i < (offset + limit) && i < this.itemsModel.size(); i++) {
            items.add(this.itemsModel.get(i));
        }

    }

    @XmlTransient
    public int getOffset() {
        return offset;
    }

    @XmlTransient
    public int getLimit() {
        return limit;
    }

    @XmlTransient
    public int getModelLimit() {
        return itemsModel.size();
    }
}

