package com.blog.samples.services.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.blog.samples.services.AccountService;
import com.blog.samples.webservices.Account;
import com.blog.samples.webservices.accountservice.CurrencyRequest;
import com.blog.samples.webservices.accountservice.CurrencyResponse;

/**
 * The Class AccountService.
 */
@Endpoint
public class AccountServiceEndpoint
{
	private static final String TARGET_NAMESPACE = "http://com/blog/samples/webservices/accountservice";

	@Autowired
	private AccountService accountService;

	
	@PayloadRoot(localPart = "CurrencyRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload CurrencyResponse getCurrency(@RequestPayload CurrencyRequest request)
	{
		CurrencyResponse response = new CurrencyResponse();

		/* call Spring injected service implementation to retrieve currency exchange value */
		Account account = accountService.getCurrency(request.getCurrency(),request.getValue());
	
		response.setCurrencyRes(account);
		return response;
	}

	public void setAccountService(AccountService accountService_p)
	{
		this.accountService = accountService_p;
	}
}