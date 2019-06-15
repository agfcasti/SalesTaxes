package com.agfcasty.salestaxes.product;

import com.agfcasty.salestaxes.tax.LocalTaxValues;

/**
 * MedicalProduct is a product with type Medical
 *
 * @author CastiglioniAG
 */
public class MedicalProduct extends Product {


	public MedicalProduct()
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
    public MedicalProduct(String name, double price, boolean imported, int quantity) 
	{
		super(name, price, imported, quantity);
		
	}	

        @Override
	public double getTaxValue(String country) 
	{
		if("Italy".equals(country))
		{
		return LocalTaxValues.MEDICAL_TAX.getTax();
		}
		else
		{
			return 0;
		}
	}

}
