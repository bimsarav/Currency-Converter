package com.blog.samples.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.blog.samples.webservices.Account;

/**
 * The Class AccountService.
 */
@Service
public class AccountServiceImpl implements AccountService
{

	
	// Available currency types
	String[] currencyType = {"LKR","INR","JPY","GBP","AUD","EUR"."USD","OMR"};
	// value for USD
	double[] valueArray = {131.13,62.24,101.53,0.62,1.10,0.74,1.0,0.39};
	

	/**
	 * Gets the currency.
	 *
	 * @param curency type & value for USD
	 * @return value of currency for USD
	 */

  	public Account getCurrency(String currency,double value)
 
	{
	
  		int i,j=0;
		Account response = new Account();
		
		// For normal user request
		if (value == 0){
			for(i=0; i< currencyType.length ; i++){
				j++;	
				if(currency.equals(currencyType[i])){
									
					break;
				}

			}
			
			response.setValue(valueArray[j-1]);
		}
		// For admin request to change the value of currency
		else{
			for(i=0; i< currencyType.length ; i++){
				j++;
				if(currency.equals(currencyType[i])){
				
					break;
				}
			
			}
			valueArray[j-1] = value;	
			response.setValue(valueArray[j-1]);	
		}

		return response;
	}
}

	
