/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.DataModel;
import ejb.DataModelLocal;
import entity.Moviemaster;
import entity.Theatermaster;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Vishal
 */
@Path("generic")
public class GenericResource {
    @EJB DataModelLocal ejb;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }
    @Path("getAllTheater")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Theatermaster> getAllTheater()
    {
        return ejb.getAllTheater();
    }
    @Path("getAllMovie")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Moviemaster> getAllMovie()
    {
        return ejb.getAllMovie();
    }
    @Path("addtheater/{theatername}/{city}/{state}/{location}")
    @POST
    public void addtheater(@PathParam("theatername") String theatername,@PathParam("city") String city,@PathParam("state") String state,@PathParam("location") String location)
    {
        ejb.addtheater(theatername, city, state, location);
        
    }
    @Path("addmovie/{moviename}")
    @POST
    public void addtheater(@PathParam("moviename") String moviename)
    {
        ejb.addmovie(moviename);
        
    }
    @Path("theatermovie/{theaterid}/{movieid}")
    @POST
    public void theatermovie(@PathParam("theaterid") Integer theaterid,@PathParam("movieid") Integer movieid)
    {
        ejb.addtheatermovie(theaterid, movieid);

    }
}
