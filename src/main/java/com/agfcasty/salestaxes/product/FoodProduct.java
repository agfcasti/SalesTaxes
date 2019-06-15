package com.agfcasty.salestaxes.product;

import com.agfcasty.salestaxes.tax.LocalTaxValues;

/**
 * FoodProduct is a product with type Food
 *
 * @author CastiglioniAG
 */
public class FoodProduct extends Product {

	public FoodProduct()
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
    public FoodProduct(String name, double price, boolean imported, int quantity) 
	{
		super(name, price, imported, quantity);
		
	}
	
        @Override
	public double getTaxValue(String country) 
	{
		if("Italy".equals(country))
		{
			return LocalTaxValues.FOOD_TAX.getTax();
		}
		else
		{
			return 0;
		}
	}

}
