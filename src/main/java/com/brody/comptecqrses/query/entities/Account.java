package com.brody.comptecqrses.query.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.brody.comptecqrses.commonapi.enums.AccountStatus;


@Entity
public class Account {
	
	@Id
	private String id;
	
	private double balance;
	
	@Enumerated(EnumType.STRING)
	private AccountStatus status;
	
	private String currency;
	
	@OneToMany(mappedBy = "account")
	private Collection<Operation> operations;
	
	public Account() {
		super();
	}

	public Account(String id, double balance, AccountStatus status, String currency, Collection<Operation> operations) {
		super();
		this.id = id;
		this.balance = balance;
		this.status = status;
		this.currency = currency;
		this.operations = operations;
	}

	public String getId() {
		return id;
	}

	public double getBalance() {
		return balance;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public String getCurrency() {
		return currency;
	}

	public Collection<Operation> getOperations() {
		return operations;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}
	
	
	
	
	

}
