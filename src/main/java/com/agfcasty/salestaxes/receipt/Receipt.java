package com.agfcasty.salestaxes.receipt;

import com.agfcasty.salestaxes.product.Product;
import java.util.List;


/**
 *  The Receipt contains the list of products, the sales taxes and the amount
 * 
 * @author CastiglioniAG
 */
public class Receipt {
    List<Product> productsReceipt;
    
    Double salesTaxes;
    
    Double totalAmount;

    public List<Product> getProductsReceipt() {
        return productsReceipt;
    }

    public void setProductsReceipt(List<Product> productsReceipt) {
        this.productsReceipt = productsReceipt;
    }

    public Double getSalesTaxes() {
        return salesTaxes;
    }

    public void setSalesTaxes(Double salesTaxes) {
        this.salesTaxes = salesTaxes;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
}
