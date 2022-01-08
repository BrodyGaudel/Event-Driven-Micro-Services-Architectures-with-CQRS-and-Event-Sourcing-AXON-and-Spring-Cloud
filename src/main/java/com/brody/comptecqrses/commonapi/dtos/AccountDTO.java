package com.brody.comptecqrses.commonapi.dtos;

import java.util.List;

import com.brody.comptecqrses.commonapi.enums.AccountStatus;

public class AccountDTO {
	
	
	private String id;
	
	private double balance;
	
	private AccountStatus status;
	
	private String currency;
	
	private List<OperationDTO> operationsDTO;
	
	
	
	

	public AccountDTO() {
		super();
	}

	public AccountDTO(String id, double balance, AccountStatus status, String currency,
			List<OperationDTO> operationsDTO) {
		super();
		this.id = id;
		this.balance = balance;
		this.status = status;
		this.currency = currency;
		this.operationsDTO = operationsDTO;
	}

	public List<OperationDTO> getOperationsDTO() {
		return operationsDTO;
	}

	public void setOperationsDTO(List<OperationDTO> operationsDTO) {
		this.operationsDTO = operationsDTO;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	
		
}
