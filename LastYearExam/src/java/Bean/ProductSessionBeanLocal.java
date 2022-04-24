/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Bean;

import Entity.Brand;
import Entity.Category;
import Entity.Product;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Viral Patel
 */
@Local
public interface ProductSessionBeanLocal {
    
    Collection<Brand> getBrandData();
    Collection<Category> getCategoryData();
    Collection<Product> getProductData();
    String addProductData(int qty,int price,String pname,int cid,int bid);
    String editProductData(int id,int qty,int price,String pname,int cid,int bid);
    String deleteProductData(int id);
    Product getProductById(int id);
    Collection<Product> getProductDataByCategoryIdAndBrandId(int cid,int bid);
    public Collection<Product> getProductDataByCategoryId(int cid);
}
