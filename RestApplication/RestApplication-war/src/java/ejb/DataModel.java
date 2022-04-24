/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Moviemaster;
import entity.Movietheater;
import entity.Theatermaster;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Vishal
 */
@Stateless
public class DataModel implements DataModelLocal {
    @PersistenceContext(unitName = "RestApplication-warPU")
    EntityManager em;
    @Override
    public Collection<Theatermaster> getAllTheater() {
        return em.createNamedQuery("Theatermaster.findAll").getResultList();
    }

    @Override
    public void addtheater(String theatername, String city, String state, String location) {
            try {
            Theatermaster tm=new Theatermaster();
            em.persist(tm);
                System.out.println("Inserted addtheater");
        } catch (Exception e) {
                System.out.println("error in addtheater:="+e.getMessage());
        }
    }

    @Override
    public Collection<Moviemaster> getAllMovie() {
        return em.createNamedQuery("Moviemaster.findAll").getResultList();
    }

    @Override
    public void addmovie(String moviename) {
        try {
            Moviemaster mm=new Moviemaster();
            em.persist(mm);
            System.out.println("Inserted addmovie");
        } catch (Exception e) {
            System.out.println("error in addmovie:="+e.getMessage());
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void addtheatermovie(Integer theaterid, Integer movieid) {
        try {
            //Theatermaster tm=em.find(Theatermaster.class, theaterid);
            //Moviemaster mm=em.find(Moviemaster.class,movieid);
            
            Theatermaster theatermaster= em.find(Theatermaster.class, theaterid);
            Moviemaster moviemaster = em.find(Moviemaster.class, movieid);
            
            Movietheater movietheater = new Movietheater();
            movietheater.setTheaterid(theatermaster);
            movietheater.setMovieid(moviemaster);
            
            em.persist(movietheater);
            
            Collection<Movietheater> moviemasterscollection = moviemaster.getMovietheaterCollection();
            moviemasterscollection.add(movietheater);
            moviemaster.setMovietheaterCollection(moviemasterscollection);
            em.merge(moviemaster);            
        
             System.out.println("Inserted addtheatermovie");
        } catch (Exception e) {
            System.out.println("Error in addtheatermovie:="+e.getMessage());
        }
 
    }

    @Override
    public Collection<Movietheater> gettheatermovieByMovie(Integer movieid) {
        Moviemaster moviemaster= em.find(Moviemaster.class, movieid);
            return moviemaster.getMovietheaterCollection();
    }

    @Override
    public Collection<Movietheater> gettheatermovieBytheatre(Integer thearteid) {
        Theatermaster tm=em.find(Theatermaster.class, thearteid);
        return tm.getMovietheaterCollection();
    }
}
