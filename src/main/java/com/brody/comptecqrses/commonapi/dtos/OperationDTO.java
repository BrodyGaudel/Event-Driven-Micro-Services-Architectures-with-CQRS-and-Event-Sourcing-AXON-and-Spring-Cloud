package com.brody.comptecqrses.commonapi.dtos;

import java.util.Date;

import com.brody.comptecqrses.commonapi.enums.OperationType;

public class OperationDTO {
	
	
	private Long id;
	
	private Date date;
	
	private double amount;
	
	private OperationType type;
	
	//private AccountDTO accountDTO;
	
	

	public OperationDTO() {
		super();
	}

	public OperationDTO(Long id, Date date, double amount, OperationType type) {
		super();
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.type = type;
		//this.accountDTO = accountDTO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public OperationType getType() {
		return type;
	}

	public void setType(OperationType type) {
		this.type = type;
	}

	/*public AccountDTO getAccountDTO() {
		return accountDTO;
	}

	public void setAccountDTO(AccountDTO accountDTO) {
		this.accountDTO = accountDTO;
	}*/

	
}
