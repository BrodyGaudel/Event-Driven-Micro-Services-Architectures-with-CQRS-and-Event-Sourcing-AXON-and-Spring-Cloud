package com.brody.comptecqrses.commonapi.events;

public class AccountCreditedEvent extends BaseEvent<String> {
	
	private double amount;
	private String currency;
	public AccountCreditedEvent(String id, double amount, String currency) {
		super(id);
		this.amount = amount;
		this.currency = currency;
	}
	public double getAmount() {
		return amount;
	}
	public String getCurrency() {
		return currency;
	}
	
	

}
