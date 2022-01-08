package com.brody.comptecqrses.commonapi.dtos;

public class CreditAccountRequestDTO {
	
	private String accountId;
	private double amount;
	private String currency;
	
	
	
	public CreditAccountRequestDTO(String accountId, double amount, String currency) {
		this.amount = amount;
		this.currency = currency;
		this.accountId = accountId;
	}


	public CreditAccountRequestDTO() {
		super();
	}


	public double getAmount() {
		return amount;
	}


	public String getCurrency() {
		return currency;
	}


	public String getAccountId() {
		return accountId;
	}
	
	
	
	
	
	

}
