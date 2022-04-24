package entity;

import entity.Movietheater;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-04-24T23:50:25", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Theatermaster.class)
public class Theatermaster_ { 

    public static volatile SingularAttribute<Theatermaster, String> theatername;
    public static volatile SingularAttribute<Theatermaster, String> city;
    public static volatile SingularAttribute<Theatermaster, Integer> theaterid;
    public static volatile SingularAttribute<Theatermaster, String> location;
    public static volatile CollectionAttribute<Theatermaster, Movietheater> movietheaterCollection;
    public static volatile SingularAttribute<Theatermaster, String> state;

}