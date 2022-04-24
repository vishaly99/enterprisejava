package entity;

import entity.Movietheater;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-04-24T23:50:25", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Moviemaster.class)
public class Moviemaster_ { 

    public static volatile SingularAttribute<Moviemaster, Integer> movieid;
    public static volatile CollectionAttribute<Moviemaster, Movietheater> movietheaterCollection;
    public static volatile SingularAttribute<Moviemaster, String> moviename;

}