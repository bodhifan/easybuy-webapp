package com.easybuy.resources;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.easybuy.model.bean.Productor;
import com.easybuy.model.data.ProductorEntity;
import com.easybuy.services.ProductorDao;
import com.easybuy.services.ProductorDaoImp;
import com.easybuy.utily.ConvertUtilty;

@Path("product")
public class ProductorResource
{
    ProductorDao productor = new ProductorDaoImp();
    @Path("{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Productor getProductor(@PathParam("id") int prodId)
    {
       return ConvertUtilty.convertToProductor(productor.getProductor(prodId));
    }
}
