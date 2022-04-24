/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Departmenttb;
import entity.Employeetb;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Vishal
 */
@Local
public interface NewSessionBeanLocal {
    //Department
    Collection<Departmenttb> getAllDepartment();
    //Employee
    Collection<Employeetb> getAllEmployee();
    Collection<Employeetb> getEmployeeId(Integer deptid);
    public String addEmployee(String empname,Integer deptid,String gender,String email);
    public String updateEmployee(Integer empid,String empname,Integer deptid,String gender,String email);
    public String deleteEmployee(Integer empid);
}
