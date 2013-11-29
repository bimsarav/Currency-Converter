package com.blog.samples.services;

import com.blog.samples.webservices.Account;

/**
 * The Interface AccountService.
 */
public interface AccountService
{

	/**
	 * Gets the currency.
	 *
	 * @param curency type & value for USD
	 * @return value of currency for USD
	 */
	
	public Account getCurrency(String currency,double value);
}
