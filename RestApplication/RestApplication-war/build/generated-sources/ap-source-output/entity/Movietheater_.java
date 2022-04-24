package entity;

import entity.Moviemaster;
import entity.Theatermaster;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-04-24T23:50:25", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Movietheater.class)
public class Movietheater_ { 

    public static volatile SingularAttribute<Movietheater, Theatermaster> theaterid;
    public static volatile SingularAttribute<Movietheater, Moviemaster> movieid;
    public static volatile SingularAttribute<Movietheater, Integer> id;

}