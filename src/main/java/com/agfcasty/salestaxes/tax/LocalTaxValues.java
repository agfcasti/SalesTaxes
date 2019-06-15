package com.agfcasty.salestaxes.tax;



/**
 * The Enum LocalTaxValues implements the tax values of the products based on type product
 *
 * @author CastiglioniAG
 */
public enum LocalTaxValues implements TaxValuesInterf
{

	BOOK_TAX(0.0),
	FOOD_TAX(0.0),
	MEDICAL_TAX(0.0),
	OTHER_GOODS_TAX(0.10);
	
	private double itemTaxValue;
	

	private LocalTaxValues(double taxValue)
	{
		itemTaxValue = taxValue;
	}
	

        @Override
	public double getTax()
	{
		return itemTaxValue;
	}
	
}
