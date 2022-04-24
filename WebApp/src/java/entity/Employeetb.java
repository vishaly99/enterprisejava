/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vishal
 */
@Entity
@Table(name = "employeetb", catalog = "employeedb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employeetb.findAll", query = "SELECT e FROM Employeetb e"),
    @NamedQuery(name = "Employeetb.findByEmpid", query = "SELECT e FROM Employeetb e WHERE e.empid = :empid"),
    @NamedQuery(name = "Employeetb.findByEmpname", query = "SELECT e FROM Employeetb e WHERE e.empname = :empname"),
    @NamedQuery(name = "Employeetb.findByGender", query = "SELECT e FROM Employeetb e WHERE e.gender = :gender"),
    @NamedQuery(name = "Employeetb.findByEmail", query = "SELECT e FROM Employeetb e WHERE e.email = :email"),
    @NamedQuery(name = "Employeetb.findByDeptid", query = "SELECT e FROM Employeetb e WHERE e.deptid = :deptid")})
public class Employeetb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "empid", nullable = false)
    private Integer empid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "empname", nullable = false, length = 50)
    private String empname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "gender", nullable = false, length = 50)
    private String gender;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @JoinColumn(name = "deptid", referencedColumnName = "deptid", nullable = false)
    @ManyToOne(optional = false)
    private Departmenttb deptid;

    public Employeetb() {
    }

    public Employeetb(Integer empid) {
        this.empid = empid;
    }

    public Employeetb(Integer empid, String empname, String gender, String email) {
        this.empid = empid;
        this.empname = empname;
        this.gender = gender;
        this.email = email;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
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

    public Departmenttb getDeptid() {
        return deptid;
    }

    public void setDeptid(Departmenttb deptid) {
        this.deptid = deptid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empid != null ? empid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employeetb)) {
            return false;
        }
        Employeetb other = (Employeetb) object;
        if ((this.empid == null && other.empid != null) || (this.empid != null && !this.empid.equals(other.empid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Employeetb[ empid=" + empid + " ]";
    }
    
}
