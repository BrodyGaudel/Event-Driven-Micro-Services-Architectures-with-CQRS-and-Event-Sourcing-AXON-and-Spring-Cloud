package com.brody.comptecqrses.commonapi.events;

import com.brody.comptecqrses.commonapi.enums.AccountStatus;

public class AccountCreatedEvent extends BaseEvent<String> {
	
	private double initialBalance;
	private String currency;
	private AccountStatus status;
	
	
	public AccountCreatedEvent(String id, double initialBalance, String currency, AccountStatus status) {
		super(id);
		this.initialBalance = initialBalance;
		this.currency = currency;
		this.status = status;
	}
	
	
	public double getInitialBalance() {
		return initialBalance;
	}
	public String getCurrency() {
		return currency;
	}


	public AccountStatus getStatus() {
		return status;
	}
	
	
	
	

}
