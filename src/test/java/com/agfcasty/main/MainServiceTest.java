/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agfcasty.main;


import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.agfcasty.salestaxes.product.BookProduct;
import com.agfcasty.salestaxes.product.FoodProduct;
import com.agfcasty.salestaxes.product.MedicalProduct;
import com.agfcasty.salestaxes.product.OthersProduct;
import com.agfcasty.salestaxes.product.Product;
import com.agfcasty.salestaxes.receipt.Receipt;
import static junit.framework.Assert.assertEquals;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
/**
 *
 * @author CastiglioniAG
 */
public class MainServiceTest {
    
    private static final Logger logger = LogManager.getLogger(MainServiceTest.class.getName());
    
    public MainServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

  @Test
    public void testMainServiceFirstCart() {
        /*Test first cart*/
        String country = "Italy";
        ArrayList<Product> products = new ArrayList<Product>();
        Product book = new BookProduct("Book", 12.49, false, 1);
        Product music = new OthersProduct("Music CD", 14.99, false, 1);
        Product chocolate = new FoodProduct("Chocolate", 0.85, false, 1);

        products.add(book);
        products.add(music);
        products.add(chocolate);

        MainService instance = new MainService();
        Receipt receipt = new Receipt();
        receipt.setSalesTaxes(1.5);
        receipt.setTotalAmount(29.83);
        Receipt expResult = receipt;
        Receipt result = instance.mainService(products, country);
        Double salesTax = result.getSalesTaxes();
        assertEquals(expResult.getSalesTaxes(), salesTax);

        Double totalAmount = result.getTotalAmount();
        assertEquals(expResult.getTotalAmount(), totalAmount);

    }

    @Test
    public void testMainServiceSecondCart() {
        /*Test second cart*/
        String country = "Italy";
        ArrayList<Product> products2 = new ArrayList<Product>();
        Product importedChocolate = new FoodProduct("Imported box of chocolates", 10, true, 1);
        Product importedPerfume = new OthersProduct("imported bottle of perfume", 47.50, true, 1);

        products2.add(importedChocolate);
        products2.add(importedPerfume);

        MainService instance = new MainService();
        Receipt receipt2 = new Receipt();
        receipt2.setSalesTaxes(7.65);
        receipt2.setTotalAmount(65.15);
        Receipt expResult2 = receipt2;
        Receipt result2 = instance.mainService(products2, country);
        Double salesTax = result2.getSalesTaxes();
        assertEquals(expResult2.getSalesTaxes(), salesTax);

        Double totalAmount = result2.getTotalAmount();
        assertEquals(expResult2.getTotalAmount(), totalAmount);

    }

    @Test
    public void testMainServiceThirdCart() {
        /*Test third cart*/
        String country = "Italy";
        ArrayList<Product> products3 = new ArrayList<Product>();
        Product importedPerfume2 = new OthersProduct("Imported bottle of perfume", 27.99, true, 1);
        Product bottlePerfume = new OthersProduct("Bottle of perfume", 18.99, false, 1);
        MedicalProduct headachePacket = new MedicalProduct("Packet of headache", 9.75, false, 1);
        Product importedChocolate1 = new FoodProduct("Imported chocolate", 11.25, true, 1);

        products3.add(importedPerfume2);
        products3.add(bottlePerfume);
        products3.add(headachePacket);
        products3.add(importedChocolate1);

        MainService instance = new MainService();
        Receipt receipt3 = new Receipt();
        receipt3.setSalesTaxes(6.70);
        receipt3.setTotalAmount(74.68);
        Receipt expResult3 = receipt3;
        Receipt result3 = instance.mainService(products3, country);
        Double salesTax = result3.getSalesTaxes();
        assertEquals(expResult3.getSalesTaxes(), salesTax);

        Double totalAmount = result3.getTotalAmount();
        assertEquals(expResult3.getTotalAmount(), totalAmount);

    }

    /**
     * Test of mainService method, of class MainService.
     */
    @Test
    public void testMainService() {
        /*Execution of three carts*/
        logger.info("START - All carts");
        testMainServiceFirstCart();
        testMainServiceSecondCart();
        testMainServiceThirdCart();
        logger.info("END - All carts");
    }

}

