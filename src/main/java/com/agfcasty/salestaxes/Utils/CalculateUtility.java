
package com.agfcasty.salestaxes.Utils;


import java.text.DecimalFormat;

/**
 * Contains methods that help to calculate values.
 * 
 * @author CastiglioniAG
 */
public class CalculateUtility {
    
         private static final double ROUND_UP = 20.0;
        
	public static double roundUp(double value)
	{
               return  Math.ceil(value * ROUND_UP) / 20.0;
	}
        
        public static double truncate(double value)
	{
		String result = new DecimalFormat("0.00").format(value).replace(",", ".");
		return Double.parseDouble(result);
	}
}
