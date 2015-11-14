package com.easybuy.resources;
/* Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.*/

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.easybuy.exceptions.NotContentException;
import com.easybuy.model.bean.ItemsRepresentation;
import com.easybuy.model.bean.Productor;
import com.easybuy.model.bean.Productors;

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
@Path("productors")
@Produces({MediaType.APPLICATION_JSON})
public class ProductorsResource
{

    @GET
    public Productors query(
            @Context javax.ws.rs.core.UriInfo info,
            @QueryParam("offset") @DefaultValue("-1") int offset, @DefaultValue("-1") @QueryParam("limit") int limit) {

        if (offset == -1 || limit == -1) {
            offset = offset == -1 ? 0 : offset;
            limit = limit == -1 ? 10 : limit;

            throw new WebApplicationException(
                    Response.seeOther(info.getRequestUriBuilder().queryParam("offset", offset)
                            .queryParam("limit", limit).build())
                            .build()
            );
        }

        return new Productors(offset, limit);
    }

    @Path("{id}")
    @GET
    public Productor get(@PathParam("id") String id) {
        
        Productor productor = new Productors().getProductor(Integer.parseInt(id));
        if (productor == null)
        {
            throw new NotContentException();
        }
        
        return productor;
        
    }
}
