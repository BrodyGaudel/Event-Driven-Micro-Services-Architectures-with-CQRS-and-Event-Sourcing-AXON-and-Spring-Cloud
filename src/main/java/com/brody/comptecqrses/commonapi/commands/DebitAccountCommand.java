package com.brody.comptecqrses.commonapi.commands;

public class DebitAccountCommand extends BaseCommand<String> {
	
	private double amount;
	private String currency;
	
	public DebitAccountCommand(String id, double amount, String currency) {
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
