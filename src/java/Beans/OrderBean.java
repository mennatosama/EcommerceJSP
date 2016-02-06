/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Rawan
 */
public class OrderBean {
    public  OrderBean(){
        
    }
    private double total_Price;
    private int quantity;
    private int date;

    public void setTotal_Price(double total_Price) {
        this.total_Price = total_Price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public double getTotal_Price() {
        return total_Price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getDate() {
        return date;
    }
    
}
