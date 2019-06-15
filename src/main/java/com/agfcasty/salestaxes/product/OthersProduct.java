package com.agfcasty.salestaxes.product;

import com.agfcasty.salestaxes.tax.LocalTaxValues;



/**
 * OthersProduct is a product with type other
 *
 * @author CastiglioniAG
 */
public class OthersProduct extends Product {


	public OthersProduct()
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
    public OthersProduct(String name, double price, boolean imported, int quantity) 
	{
		super(name, price, imported, quantity);
		
	}
	

        @Override
	public double getTaxValue(String country)
	{
		if("Italy".equals(country))
		{
		return LocalTaxValues.OTHER_GOODS_TAX.getTax();
		}
		else
		{
			return 0;
		}
	}
}
