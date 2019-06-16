
package com.agfcasty.main;

import com.agfcasty.salestaxes.calculateservice.CartService;
import com.agfcasty.salestaxes.product.Product;
import com.agfcasty.salestaxes.receipt.Receipt;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author CastiglioniAG
 */
public class MainService {
        
    public Receipt mainService(List<Product> products, String country){
                    CartService cartService = new CartService();
                    Receipt receipt = cartService.processCart(products, country);
                    cartService.printReceipt(receipt);
                    return receipt;   
    }
}
