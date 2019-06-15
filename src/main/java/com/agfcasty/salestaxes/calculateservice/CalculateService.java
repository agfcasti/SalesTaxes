package com.agfcasty.salestaxes.calculateservice;

import com.agfcasty.salestaxes.Utils.CalculateUtility;
import java.util.List;
import com.agfcasty.salestaxes.product.Product;
import com.agfcasty.salestaxes.receipt.Receipt;

/**
 * A class of services to calculate the values of the receipt
 *
 * @author CastiglioniAG
 */
public class CalculateService {

    private final Double TAX_IMPORTED = 0.05;

    public Receipt calculateCheckoutReceipt(List<Product> productList, String country) {
        Double totalAmount = new Double(0);
        Double salesTaxes = new Double(0);
        Receipt receipt = new Receipt();
        try {
            //if list is not empty, it calculates the checkout
            if (productList != null && !productList.isEmpty()) {

                for (Product actualProd : productList) {

                    //calculate the product tax value
                    double productTax = this.calculateTaxService(actualProd.getPrice(), actualProd.getTaxValue(country), actualProd.isImported());

                    //truncate the tax values
                    productTax = CalculateUtility.truncate(productTax);

                    //add the tax to the cost of the product
                    Double taxedCost = CalculateUtility.truncate(actualProd.getPrice() + productTax);

                    //multiply for the number of this product in the cart
                    productTax = CalculateUtility.truncate(productTax * actualProd.getQuantity());

                    //sets the taxed cost of the product
                    actualProd.setTaxedCost(taxedCost);

                    //calculates the total amount and the sale taxes amount
                    totalAmount += taxedCost;
                    salesTaxes += productTax;
                }
            }

            //sets the values of receipt
            receipt.setProductsReceipt(productList);
            receipt.setSalesTaxes(CalculateUtility.truncate(salesTaxes));
            receipt.setTotalAmount(CalculateUtility.truncate(totalAmount));
        } catch (Exception ex) {
            System.out.println("Generic error during cart calculation");
        }

        return receipt;
    }


    public double calculateTaxService(double price, double localTax, boolean imported) {
        //Calculates tax cost
        double tax = price * localTax;

        //if imported, caluclates additional tax
        if (imported == true) {
            tax += (price * TAX_IMPORTED);
        }

        //rounds up to the nearest 0.05
        tax = CalculateUtility.roundUp(tax);

        return tax;
    }

}
