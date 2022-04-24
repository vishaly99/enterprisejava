/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.NewSessionBeanLocal;
import entity.Departmenttb;
import entity.Employeetb;
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
    @EJB NewSessionBeanLocal ejb;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }
    @Path("getalldept")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Departmenttb> getalldept()
    {
        return ejb.getAllDepartment();
    }
    @Path("getallemp")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Employeetb> getallemp()
    {
        return ejb.getAllEmployee();
    }
    @Path("addemp/{empname}/{deptid}/{gender}/{email}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String addemp(@PathParam("empname") String empname,@PathParam("deptid") Integer deptid,@PathParam("gender") String gender,@PathParam("email") String email)
    {
        return ejb.addEmployee(empname, deptid, gender, email);
    }
    @Path("updateemp/{empid}/{empname}/{deptid}/{gender}/{email}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String updateemp(@PathParam("empid") Integer empid,@PathParam("empname") String empname,@PathParam("deptid") Integer deptid,@PathParam("gender") String gender,@PathParam("email") String email)
    {
        return ejb.updateEmployee(empid,empname, deptid, gender, email);
    }
    @Path("deleteemp/{empid}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteemp(@PathParam("empid") Integer empid)
    {
        return ejb.deleteEmployee(empid);
    }
}
