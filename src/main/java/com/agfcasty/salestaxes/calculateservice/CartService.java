package com.agfcasty.salestaxes.calculateservice;

import java.util.List;
import com.agfcasty.salestaxes.product.Product;
import com.agfcasty.salestaxes.receipt.Receipt;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 *
 * @author CastiglioniAG
 */
public class CartService {

    private static final Logger logger = LogManager.getLogger(CartService.class.getName());
    
    public Receipt processCart(List<Product> productList, String country) {
        CalculateService calculateService = new CalculateService();
        //return receipt
        return calculateService.calculateCheckoutReceipt(productList, country);
    }

    public void printReceipt(Receipt receipt) {
        logger.info("----Receipt----");
        List<Product> listProduct = receipt.getProductsReceipt();
        if (listProduct != null && !listProduct.isEmpty()) {
            for (Product product : listProduct) {
                logger.info(product.getQuantity() + " " + product.getName() + " " + product.getTaxedCost());
            }
            logger.info("Sales taxes: " + receipt.getSalesTaxes());
            logger.info("Total: " + receipt.getTotalAmount());
        }

    }

}
