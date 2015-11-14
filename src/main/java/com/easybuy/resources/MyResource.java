package com.easybuy.resources;

import java.util.List;
import java.util.Map.Entry;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
   // @Path("/getit")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    @Path("/my")
    @GET
    public String geHeaders(@Context HttpHeaders hh){
        
       MultivaluedMap<String, String> multivaluedMap =  hh.getRequestHeaders();
      
       String build = "";
       for (Entry<String,List<String>> itor : multivaluedMap.entrySet())
       {
            build +="header: "+ itor.getKey()+"  value:" + itor.getValue().toString();
       }
       
       return build;
    }
    
    @Path("/mylinks")
    @GET
    public Response getLinks()
    {
        Link link = Link.fromUri("mylinks/1").rel("type").type("text/plain").build();
        Response response = Response.noContent().links(link).build();
        
        return response;
    }
    
    
}
