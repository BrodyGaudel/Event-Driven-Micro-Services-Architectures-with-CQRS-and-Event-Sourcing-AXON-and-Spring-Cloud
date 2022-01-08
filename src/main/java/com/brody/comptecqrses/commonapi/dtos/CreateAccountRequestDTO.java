package com.brody.comptecqrses.commonapi.dtos;

public class CreateAccountRequestDTO {
	
	private double initialBalance;
	private String currency;
	
	
	
	
	public CreateAccountRequestDTO() {
	
	}
	
	public CreateAccountRequestDTO(double initialBalance, String currency) {

		this.initialBalance = initialBalance;
		this.currency = currency;
	}
	
	public double getInitialBalance() {
		return initialBalance;
	}
	
	public void setInitialBalance(double initialBalance) {
		this.initialBalance = initialBalance;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	

}
