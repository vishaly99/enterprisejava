/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import Client.JerseyClient;
import Entity.Brand;
import Entity.Category;
import Entity.Product;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Viral Patel
 */
@Named(value = "productJSFManagedBean")
@ApplicationScoped
public class productJSFManagedBean {

        Response res;
    JerseyClient jc;
    
    Collection<Product> productSearchCollection;
    
    Collection<Product> product;
    Collection<Brand> brand;
    Collection<Category> category;
    GenericType<Collection<Product>> gProductList;
    GenericType<Collection<Brand>> gBrandList;
    GenericType<Collection<Category>> gCategoryList;
    GenericType<Product> gProduct;
    Product p = new Product();
    int id,qty,price,cid,bid;
    String pname;

    
    /**
     * Creates a new instance of productJSFManagedBean
     */
    @PostConstruct
    public void init()
    {
        jc = new JerseyClient();
    }
    public productJSFManagedBean() {
        
    }

    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    public Collection<Product> getProductSearchCollection() {
        return productSearchCollection;
    }

    public void setProductSearchCollection(Collection<Product> productSearchCollection) {
        this.productSearchCollection = productSearchCollection;
    }
    
    
    
    public Collection<Brand> getBrandData()
    {
        gBrandList = new GenericType<Collection<Brand>>(){};
        res = jc.getBrandData(Response.class);
        return res.readEntity(gBrandList);
    }

    public Collection<Category> getCategoryData()
    {
        gCategoryList = new GenericType<Collection<Category>>(){};
        res = jc.getCategoryData(Response.class);
        return res.readEntity(gCategoryList);
    }

    public Collection<Product> getProductData()
    {
        gProductList = new GenericType<Collection<Product>>(){};
        
        res = jc.getProductData(Response.class);
        Collection<Product> p = res.readEntity(gProductList);
        
        return p;
    }
    
    public String getCategoryIdAndBrandId()
    {
        gProductList = new GenericType<Collection<Product>>(){};
        res = jc.getProductDataByCategoryIdAndBrandId(Response.class,String.valueOf(cid),String.valueOf(bid));
        productSearchCollection = res.readEntity(gProductList);
        return "displaySearchProduct.xhtml?faces-redirect=true";
    }

    public String getCategoryId()
    {
        gProductList = new GenericType<Collection<Product>>(){};
        res = jc.getProductDataByCategoryId(Response.class,String.valueOf(cid));
        productSearchCollection = res.readEntity(gProductList);
        return "displaySearchProductByCategoryId.xhtml?faces-redirect=true";
    }
    
    
    public String addProductData()
    {
        System.out.println(qty+" "+price+" "+pname+" "+cid+" "+bid);
        jc.addProductData(String.valueOf(qty),String.valueOf( price), pname,String.valueOf( cid),String.valueOf( bid));
        
        return "index.xhtml?faces-redirect=true";
    }
    
    public String deleteProductData(int ids)
    {
        jc.deleteProductData(String.valueOf(ids));
        return "index.xhtml?faces-redirect=true";
    }
    
    public String getProductDataById(int ids)
    {
        gProduct = new GenericType<Product>(){};
        res = jc.getProductDataById(Response.class,String.valueOf(ids));
        Product pb = res.readEntity(gProduct);
        id = pb.getId();
        qty = pb.getQuantity();
        price = pb.getPrice();
        pname = pb.getProductName();
        cid = pb.getCategoryId().getId();
        bid = pb.getBrandId().getId();
        return "updateProduct.xhtml?faces-redirect=true";
    }
    
    public String editProductData()
    {
        jc.editProductData(String.valueOf(id),String.valueOf(qty),String.valueOf(price), pname,String.valueOf(cid),String.valueOf(bid));
        return "index.xhtml?faces-redirect=true";
    }
    
}
