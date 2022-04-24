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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vishal
 */
@Entity
@Table(name = "movietheater")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movietheater.findAll", query = "SELECT m FROM Movietheater m"),
    @NamedQuery(name = "Movietheater.findById", query = "SELECT m FROM Movietheater m WHERE m.id = :id")})
public class Movietheater implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @JoinColumn(name = "movieid", referencedColumnName = "movieid")
    @ManyToOne(optional = false)
    private Moviemaster movieid;
    @JoinColumn(name = "theaterid", referencedColumnName = "theaterid")
    @ManyToOne(optional = false)
    private Theatermaster theaterid;

    public Movietheater() {
    }

    public Movietheater(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Moviemaster getMovieid() {
        return movieid;
    }

    public void setMovieid(Moviemaster movieid) {
        this.movieid = movieid;
    }

    public Theatermaster getTheaterid() {
        return theaterid;
    }

    public void setTheaterid(Theatermaster theaterid) {
        this.theaterid = theaterid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movietheater)) {
            return false;
        }
        Movietheater other = (Movietheater) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Movietheater[ id=" + id + " ]";
    }
    
}
