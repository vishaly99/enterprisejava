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
import javax.ejb.Local;

/**
 *
 * @author Vishal
 */
@Local
public interface DataModelLocal {
    //TheaterMaster
    Collection<Theatermaster> getAllTheater();
    void addtheater(String theatername,String city,String state,String location);
    //MovieMaster
    Collection<Moviemaster> getAllMovie();
    void addmovie(String moviename);
    //MoviewTheater
    void addtheatermovie(Integer theaterid,Integer movieid);
    Collection<Movietheater> gettheatermovieByMovie(Integer movieid);
     Collection<Movietheater> gettheatermovieBytheatre(Integer thearteid);
}
