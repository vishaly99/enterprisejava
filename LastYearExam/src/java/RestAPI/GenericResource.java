/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package RestAPI;

import Bean.ProductSessionBeanLocal;
import Entity.Brand;
import Entity.Category;
import Entity.Product;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Viral Patel
 */
@Path("generic")
public class GenericResource {

    @EJB
    private ProductSessionBeanLocal psbl;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of RestAPI.GenericResource
     * @return an instance of java.lang.String
     */
    
    @Path("getBrandData")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Brand> getBrandData()
    {
        return psbl.getBrandData();
    }
    @Path("getCategoryData")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Category> getCategoryData()
    {
        return psbl.getCategoryData();
    }
    @Path("getProductData")
    @GET
    @Produces(MediaType.APPLICATION_JSON)    
    public Collection<Product> getProductData()
    {
        return psbl.getProductData();
    }

    @Path("deleteProductData/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)    
    public String deleteProductData(@PathParam("id") int id)
    {
        psbl.deleteProductData(id);
        return "deleted";
    }

    @Path("getProductDataById/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)    
    public Product getProductDataById(@PathParam("id") int id)
    {
        return psbl.getProductById(id);
    }
    
    
    @Path("getProductDataByCategoryIdAndBrandId/{cid}/{bid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)    
    public Collection<Product> getProductDataByCategoryIdAndBrandId(@PathParam("cid") int cid,@PathParam("bid") int bid)
    {
        return psbl.getProductDataByCategoryIdAndBrandId(cid, bid);
    }

    @Path("getProductDataByCategoryId/{cid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)    
    public Collection<Product> getProductDataByCategoryId(@PathParam("cid") int cid)
    {
        return psbl.getProductDataByCategoryId(cid);
    }

    
    @Path("addProductData/{qty}/{price}/{pname}/{cid}/{bid}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)    
    public String addProductData(@PathParam("qty") int qty,@PathParam("price") int price,@PathParam("pname") String pname,@PathParam("cid") int cid,@PathParam("bid") int bid)
    {
        psbl.addProductData(qty, price, pname, cid, bid);
        return "inserted";
    }
    
    @Path("editProductData/{id}/{qty}/{price}/{pname}/{cid}/{bid}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)    
    public String editProductData(@PathParam("id") int id,@PathParam("qty") int qty,@PathParam("price") int price,@PathParam("pname") String pname,@PathParam("cid") int cid,@PathParam("bid") int bid)
    {
        psbl.editProductData(id,qty, price, pname, cid, bid);
        return "updated";
    }
    
    
}
