package com.brody.comptecqrses.commonapi.dtos;

public class DebitAccountRequestDTO {
	
	private String accountId;
	private double amount;
	private String currency;
	

	public DebitAccountRequestDTO(String accountId, double amount, String currency) {
		super();
		this.accountId = accountId;
		this.amount = amount;
		this.currency = currency;
	}
	
	
	public String getAccountId() {
		return accountId;
	}
	public double getAmount() {
		return amount;
	}
	public String getCurrency() {
		return currency;
	}
	
	

}
