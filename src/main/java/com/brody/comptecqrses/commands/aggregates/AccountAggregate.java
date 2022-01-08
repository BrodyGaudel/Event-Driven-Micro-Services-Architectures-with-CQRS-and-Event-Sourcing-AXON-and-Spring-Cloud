package com.brody.comptecqrses.commands.aggregates;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.brody.comptecqrses.commonapi.commands.CreateAccountCommand;
import com.brody.comptecqrses.commonapi.commands.CreditAccountCommand;
import com.brody.comptecqrses.commonapi.commands.DebitAccountCommand;
import com.brody.comptecqrses.commonapi.enums.AccountStatus;
import com.brody.comptecqrses.commonapi.events.AccountActivatedEvent;
import com.brody.comptecqrses.commonapi.events.AccountCreatedEvent;
import com.brody.comptecqrses.commonapi.events.AccountCreditedEvent;
import com.brody.comptecqrses.commonapi.events.AccountDebitedEvent;
import com.brody.comptecqrses.commonapi.exceptions.AmountNegativeException;
import com.brody.comptecqrses.commonapi.exceptions.BalanceNotSufficientException;

@Aggregate 
public class AccountAggregate {
	
	@AggregateIdentifier
	private String accountId;
	private double balance;
	private String currency;
	private AccountStatus status;
	
	public AccountAggregate() {
		//Required by AXON 
	}
	
	@CommandHandler
	public AccountAggregate(CreateAccountCommand createAccountCommand) {
		
		if(createAccountCommand.getInitialBalance()<0) {
			throw new RuntimeException("Impossible de créer un compte avec un solde négatif...");
		}
		else {
			AggregateLifecycle.apply(new AccountCreatedEvent(
					createAccountCommand.getId(),
					createAccountCommand.getInitialBalance(),
					createAccountCommand.getCurrency(),
					AccountStatus.CREATED
					));
		}
	}
	 
	@EventSourcingHandler
	public void on(AccountCreatedEvent event) {
		
		this.accountId = event.getId();
		this.balance = event.getInitialBalance();
		this.currency = event.getCurrency();
		this.status = AccountStatus.CREATED;	
		AggregateLifecycle.apply(new AccountActivatedEvent(
				event.getId(),
				AccountStatus.ACTIVATED
				));
	}
	
	@EventSourcingHandler
	public void on(AccountActivatedEvent event) {
		this.status=event.getStatus();
	}
	
	@CommandHandler
	public void handler(CreditAccountCommand command) {
		
		if(command.getAmount()<0) {
			throw new AmountNegativeException("Amount should not be négatif...");
		}
		else {
			AggregateLifecycle.apply(new AccountCreditedEvent(
					command.getId(),
					command.getAmount(),
					command.getCurrency()
					
					));
		}
		
	}
	
	@EventSourcingHandler
	public void on(AccountCreditedEvent event) {
		this.balance+=event.getAmount();
	}
	
	@CommandHandler
	public void handler(DebitAccountCommand command) {
		
		if(command.getAmount()<0) {
			throw new AmountNegativeException("Amount should not be négatif...");
		}
		else if(this.balance<command.getAmount()) {
			throw new BalanceNotSufficientException("Balance Not Sufficient Exception => "+balance);
		}
		else {
			AggregateLifecycle.apply(new AccountDebitedEvent(
					command.getId(),
					command.getAmount(),
					command.getCurrency()
					
					));
		}
		
	}
	
	@EventSourcingHandler
	public void on(AccountDebitedEvent event) {
		this.balance-=event.getAmount();
	}
	
	
	
	
	
	
	
	
	
	

	public String getAccountId() {
		return accountId;
	}

	public double getBalance() {
		return balance;
	}

	public String getCurrency() {
		return currency;
	}

	public AccountStatus getStatus() {
		return status;
	}
	
	
	
	
	
	

}
