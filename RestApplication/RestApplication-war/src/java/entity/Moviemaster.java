/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Vishal
 */
@Entity
@Table(name = "moviemaster")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moviemaster.findAll", query = "SELECT m FROM Moviemaster m"),
    @NamedQuery(name = "Moviemaster.findByMovieid", query = "SELECT m FROM Moviemaster m WHERE m.movieid = :movieid"),
    @NamedQuery(name = "Moviemaster.findByMoviename", query = "SELECT m FROM Moviemaster m WHERE m.moviename = :moviename")})
public class Moviemaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "movieid")
    private Integer movieid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "moviename")
    private String moviename;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movieid")
    private Collection<Movietheater> movietheaterCollection;

    public Moviemaster() {
    }

    public Moviemaster(Integer movieid) {
        this.movieid = movieid;
    }

    public Moviemaster(Integer movieid, String moviename) {
        this.movieid = movieid;
        this.moviename = moviename;
    }

    public Integer getMovieid() {
        return movieid;
    }

    public void setMovieid(Integer movieid) {
        this.movieid = movieid;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    @XmlTransient
    public Collection<Movietheater> getMovietheaterCollection() {
        return movietheaterCollection;
    }

    public void setMovietheaterCollection(Collection<Movietheater> movietheaterCollection) {
        this.movietheaterCollection = movietheaterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movieid != null ? movieid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moviemaster)) {
            return false;
        }
        Moviemaster other = (Moviemaster) object;
        if ((this.movieid == null && other.movieid != null) || (this.movieid != null && !this.movieid.equals(other.movieid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Moviemaster[ movieid=" + movieid + " ]";
    }
    
}
