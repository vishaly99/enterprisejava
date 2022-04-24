/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Departmenttb;
import entity.Employeetb;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Vishal
 */
@Stateless
public class NewSessionBean implements NewSessionBeanLocal {
    @PersistenceContext(unitName = "WebAppPU")
    EntityManager em;
    @Override
    public Collection<Departmenttb> getAllDepartment() {
        return em.createNamedQuery("Departmenttb.findAll").getResultList();
    }

    @Override
    public Collection<Employeetb> getAllEmployee() {
        return em.createNamedQuery("Employeetb.findAll").getResultList();
    }

    @Override
    public String addEmployee(String empname, Integer deptid, String gender, String email) {
            try {
                //method1
//            Departmenttb d=em.find(Departmenttb.class,deptid);
//            Collection<Employeetb> emp=d.getEmployeetbCollection();
//            
//            Employeetb e=new Employeetb();
//            e.setDeptid(d);
//            e.setEmpname(empname);
//            e.setEmail(email);
//            e.setGender(gender);
//            
//            emp.add(e);
//            
//            d.setEmployeetbCollection(emp);
//            em.persist(e);
//            em.merge(d);
            //method 2
            Departmenttb d=em.find(Departmenttb.class,deptid);
            Employeetb e=new Employeetb();
            e.setDeptid(d);
            e.setEmpname(empname);
            e.setEmail(email);
            e.setGender(gender);
            em.persist(e);
            return "Inserted";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String updateEmployee(Integer empid, String empname, Integer deptid, String gender, String email) {
            try {
            Departmenttb d=(Departmenttb) em.find(Departmenttb.class,deptid);
            Employeetb e=(Employeetb) em.find(Employeetb.class,empid);
            e.setDeptid(d);
            e.setEmpname(empname);
            e.setGender(gender);
            e.setEmail(email);
            em.merge(e);
            return "Updated";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deleteEmployee(Integer empid) {
        try {
            Employeetb e=(Employeetb) em.find(Employeetb.class, empid);
            em.remove(e);
            return "Deleted";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Collection<Employeetb> getEmployeeId(Integer deptid) {
       return em.createNamedQuery("Employeetb.findByDeptid").setParameter("deptid",deptid).getResultList();
      
    }
}
