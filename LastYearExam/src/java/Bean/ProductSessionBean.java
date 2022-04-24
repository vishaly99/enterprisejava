/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package Bean;

import Entity.Brand;
import Entity.Category;
import Entity.Product;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Viral Patel
 */
@Stateless
public class ProductSessionBean implements ProductSessionBeanLocal {

    @PersistenceContext(unitName="LastYearExamPU")
    private EntityManager em;
    
    @Override
    public Collection<Brand> getBrandData() {
        return em.createNamedQuery("Brand.findAll").getResultList();
    }

    @Override
    public Collection<Category> getCategoryData() {
        return em.createNamedQuery("Category.findAll").getResultList();
    }

    @Override
    public Collection<Product> getProductData() {
        return em.createNamedQuery("Product.findAll").getResultList();
    }

    @Override
    public String addProductData(int qty, int price, String pname, int cid, int bid) {
        Category cate = em.find(Category.class, cid);
        Brand brand = em.find(Brand.class, bid);
        Product product = new Product();
        product.setQuantity(qty);
        product.setPrice(price);
        product.setProductName(pname);
        product.setCategoryId(cate);
        product.setBrandId(brand);
        em.persist(product);
        return "inserted";
    }

    @Override
    public String editProductData(int id, int qty, int price, String pname, int cid, int bid) {
        Category cate = em.find(Category.class, cid);
        Brand brand = em.find(Brand.class, bid);
        Product product = em.find(Product.class,id);
        product.setId(id);
        product.setQuantity(qty);
        product.setPrice(price);
        product.setProductName(pname);
        product.setCategoryId(cate);
        product.setBrandId(brand);
        em.merge(product);
        return "updated";
    }

    @Override
    public String deleteProductData(int id) {
        em.remove(getProductById(id));
        return "deleted";
    }

    @Override
    public Product getProductById(int id) {
        return (Product)em.createNamedQuery("Product.findById").setParameter("id", id).getSingleResult();
    }

    
    
    
    public Collection<Product> getProductDataByCategoryIdAndBrandId(int cid,int bid)
    {
        if(cid!=0 && bid!=0)
        {
            Category cate = em.find(Category.class, cid);
            Brand brand = em.find(Brand.class, bid);        
            return em.createNamedQuery("Product.findByProductByCategoryIdAndBrandId").setParameter("categoryId", cate).setParameter("brandId", brand).getResultList();
        }
        else
        {
            if(cid==0)
            {
                Brand brand = em.find(Brand.class, bid);        
                return em.createNamedQuery("Product.findByProductByBrandId").setParameter("brandId", brand).getResultList();                
            }
            else
            {
                
                    Category cate = em.find(Category.class, cid);        
                    return em.createNamedQuery("Product.findByProductByCategoryId").setParameter("categoryId", cate).getResultList();
            }
        }
    }
    
    public Collection<Product> getProductDataByCategoryId(int cid)
    {
        Category cate = em.find(Category.class, cid);        
        return em.createNamedQuery("Product.findByProductByCategoryId").setParameter("categoryId", cate).getResultList();
    }
    
    
}
