/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import client.JerseyClient;
import com.sun.xml.ws.security.trust.GenericToken;
import ejb.NewSessionBeanLocal;
import entity.Departmenttb;
import entity.Employeetb;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Vishal
 */
@Named(value = "employeeBean")
@ApplicationScoped
public class EmployeeBean {
    @EJB NewSessionBeanLocal ejb;
    Response res;
    JerseyClient client;
    Integer empid,deptid;
    String empname,gender,email;
    Collection<Departmenttb> deptlist;
    Collection<Employeetb> emplist;
    GenericType<Collection<Employeetb>> gemp;
    GenericType<Collection<Departmenttb>> gdept;
    Employeetb emp=new Employeetb();

    
    public Employeetb getEmp()
    {
        return emp;
    }

    /**
     * Creates a new instance of EmployeeBean
     */
    public void setEmp(Employeetb emp) {    
        this.emp = emp;
    }

    @PostConstruct
    public void init() {
        this.empid=0;
        client=new JerseyClient();
        gemp=new GenericType<Collection<Employeetb>>(){};
        gdept=new GenericType<Collection<Departmenttb>>(){};
        res=client.getalldept(Response.class);
        deptlist=res.readEntity(gdept);
    }
    public EmployeeBean() {
    }
    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Departmenttb> getDeptlist() {
        return deptlist;
    }

    public void setDeptlist(Collection<Departmenttb> deptlist) {
        this.deptlist = deptlist;
    }

    public Collection<Employeetb> getEmplist() {
        return emplist;
    }

    public void setEmplist(Collection<Employeetb> emplist) {
        this.emplist = emplist;
    }
    public Collection<Departmenttb> showdept()
    {
        return deptlist;
    }
    public Collection<Employeetb>showemp()
    {
        res=client.getallemp(Response.class);
        emplist=res.readEntity(gemp);
        return emplist;
    }
    public Collection<Employeetb> showempbyid()
    {
        System.out.println("Department id:="+deptid);
        //return null;
        emplist=ejb.getEmployeeId(deptid);
        return emplist;
    }
    public String addemp()
    {
        try {
            System.out.println("addemp:="+client.addemp(empname,String.valueOf(deptid), gender, email));
            return "showemp.xhtml?faces-redirect=true";
        } catch (Exception e) {
            System.out.println("Error addemp:="+e.getMessage());
            return "addemp.xhtml?faces-redirect=true";
            
        }
    }
    public String updatemp(Employeetb e)
    {
        deptid=e.getDeptid().getDeptid();
        this.emp=e;
        this.empid=e.getEmpid();
        this.empname=e.getEmpname();
        this.email=e.getEmail();
        this.gender=e.getGender();
        return "addemp.xhtml?faces-redirect=true";
    }
    public String updatemp()
    {
        try {
            System.out.println("Data:="+empid+"/n"+empname+"/n"+deptid+"/n"+gender+"/n"+email);
            System.out.println("updatemp:="+client.updateemp(String.valueOf(empid), empname, String.valueOf(deptid), gender, email));
            return "showemp.xhtml?faces-redirect=true";
        } catch (Exception e) {
            System.out.println("Error addemp:="+e.getMessage());
            return "addemp.xhtml?faces-redirect=true";
            
        }
    }
    public String deletemp(Integer empid)
    {
        try {
            System.out.println("addemp:="+client.deleteemp(String.valueOf(empid)));
            return "showemp.xhtml?faces-redirect=true";
        } catch (Exception e) {
             System.out.println("Error deleteemp:="+e.getMessage());
            return "showemp.xhtml?faces-redirect=true";
        }
    }
}
