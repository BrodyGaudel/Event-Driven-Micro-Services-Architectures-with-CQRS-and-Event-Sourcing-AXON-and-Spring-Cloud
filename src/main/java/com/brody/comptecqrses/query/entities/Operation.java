package com.brody.comptecqrses.query.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.brody.comptecqrses.commonapi.enums.OperationType;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Operation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date date;
	
	private double amount;
	
	@Enumerated(EnumType.STRING)
	private OperationType type;
	
	@ManyToOne
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Account account;
	
	
	public Operation() {
	}
	
	public Operation(Long id, Date date, double amount, OperationType type, Account account) {
		super();
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.type = type;
		this.account = account;
	}

	public Long getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public double getAmount() {
		return amount;
	}

	public OperationType getType() {
		return type;
	}

	public Account getAccount() {
		return account;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setType(OperationType type) {
		this.type = type;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	

}
