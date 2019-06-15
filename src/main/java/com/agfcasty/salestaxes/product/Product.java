package com.agfcasty.salestaxes.product;

/**
 * The Product is an element in the cart
 *
 * @author CastiglioniAG
 * 
 */
public abstract class Product 
{
	
    public String name;

    public double price;

    public Boolean imported;

    public int quantity;

    //the final price of product with tax
    protected double taxedCost;

    public Product() {
    }
            
    public Product(String name, double price, Boolean imported, int quantity) {
        this.name = name;
        this.price = price;
        this.imported = imported;
        this.quantity = quantity;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Boolean isImported() {
        return imported;
    }

    public void setImported(Boolean imported) {
        this.imported = imported;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTaxedCost() {
        return taxedCost;
    }

    public void setTaxedCost(double taxedCost) {
        this.taxedCost = taxedCost;
    }
    
    /**
     *
     * @param country
     * @return
     */
    public abstract double getTaxValue(String country);

}
