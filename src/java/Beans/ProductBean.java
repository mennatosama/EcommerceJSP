/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author asma
 */
public class ProductBean {
    public ProductBean(){
        
    }
    
    private String product_Name;
    private double product_Price;
    private String product_Description;
    private int product_Quantity;
    private String product_Pic;

    public String getProduct_Name() {
        return product_Name;
    }

    public double getProduct_Price() {
        return product_Price;
    }

    public String getProduct_Description() {
        return product_Description;
    }

    public int getProduct_Quantity() {
        return product_Quantity;
    }

    public String getProduct_Pic() {
        return product_Pic;
    }

    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    public void setProduct_Price(double product_Price) {
        this.product_Price = product_Price;
    }

    public void setProduct_Description(String product_Description) {
        this.product_Description = product_Description;
    }

    public void setProduct_Quantity(int product_Quantity) {
        this.product_Quantity = product_Quantity;
    }

    public void setProduct_Pic(String product_Pic) {
        this.product_Pic = product_Pic;
    }
    
    
}

