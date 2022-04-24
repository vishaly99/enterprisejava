package Entity;

import Entity.Brand;
import Entity.Category;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-04-23T22:38:07", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Integer> quantity;
    public static volatile SingularAttribute<Product, Integer> price;
    public static volatile SingularAttribute<Product, Brand> brandId;
    public static volatile SingularAttribute<Product, Integer> id;
    public static volatile SingularAttribute<Product, String> productName;
    public static volatile SingularAttribute<Product, Category> categoryId;

}