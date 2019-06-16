package com.agfcasty.salestaxes.calculateservice;

import static com.agfcasty.salestaxes.calculateservice.CalculateService.logger;
import java.util.List;
import com.agfcasty.salestaxes.product.Product;
import com.agfcasty.salestaxes.receipt.Receipt;

/**
 *
 * @author CastiglioniAG
 */
public class CartService {

    public Receipt processCart(List<Product> productList, String country) {
        CalculateService calculateService = new CalculateService();
        //return receipt
        return calculateService.calculateCheckoutReceipt(productList, country);
    }

    public void printReceipt(Receipt receipt) {
        System.out.println("----Receipt----");
        List<Product> listProduct = receipt.getProductsReceipt();
        if (listProduct != null && !listProduct.isEmpty()) {
            for (Product product : listProduct) {
                System.out.println(product.getQuantity() + " " + product.getName() + " " + product.getTaxedCost());
            }
            logger.info("Sales taxes: " + receipt.getSalesTaxes());
            logger.info("Total: " + receipt.getTotalAmount());
        }

    }

}
