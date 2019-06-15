package com.agfcasty.salestaxes.product;


import com.agfcasty.salestaxes.tax.LocalTaxValues;

/**
 * BookProduct is a product with type Book
 *
 * @author CastiglioniAG
 */
public class BookProduct extends Product {

	public BookProduct()
	{
		super();
	}

    /**
     *
     * @param name
     * @param price
     * @param imported
     * @param quantity
     */
    public BookProduct(String name, double price, boolean imported, int quantity) 
	{
		super(name, price, imported, quantity);
		
	}

        @Override
	public double getTaxValue(String country)
	{		
		if("Italy".equals(country))
		{
			return LocalTaxValues.BOOK_TAX.getTax();
		}
		else
		{
			return 0;
		}
	}
}
