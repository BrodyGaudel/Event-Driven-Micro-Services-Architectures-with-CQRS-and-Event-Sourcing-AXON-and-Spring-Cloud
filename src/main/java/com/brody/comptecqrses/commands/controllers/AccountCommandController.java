package com.brody.comptecqrses.commands.controllers;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brody.comptecqrses.commonapi.commands.CreateAccountCommand;
import com.brody.comptecqrses.commonapi.commands.CreditAccountCommand;
import com.brody.comptecqrses.commonapi.commands.DebitAccountCommand;
import com.brody.comptecqrses.commonapi.dtos.CreateAccountRequestDTO;
import com.brody.comptecqrses.commonapi.dtos.CreditAccountRequestDTO;
import com.brody.comptecqrses.commonapi.dtos.DebitAccountRequestDTO;

@RestController
@RequestMapping(path = "/commands/account")
public class AccountCommandController {
	
	private CommandGateway commandGateway;
	private EventStore eventStore;
	
	public AccountCommandController(CommandGateway commandGateway, EventStore eventStore) {
		
		this.commandGateway = commandGateway;
		this.eventStore = eventStore;
	}



	@PostMapping(path = "/create")
	public CompletableFuture<String> createAccount(@RequestBody CreateAccountRequestDTO request) {
		CompletableFuture<String> commandResponse = commandGateway.send(new CreateAccountCommand(
				UUID.randomUUID().toString(),
				request.getInitialBalance(),
				request.getCurrency()
				));
		return commandResponse;
	}
	
	@PutMapping(path = "/credit")
	public CompletableFuture<String> creditAccount(@RequestBody CreditAccountRequestDTO request) {
		CompletableFuture<String> commandResponse = commandGateway.send(new CreditAccountCommand(
				request.getAccountId(),
				request.getAmount(),
				request.getCurrency()
				
				));
		return commandResponse;
	}
	
	@PutMapping(path = "/debit")
	public CompletableFuture<String> debitAccount(@RequestBody DebitAccountRequestDTO request) {
		CompletableFuture<String> commandResponse = commandGateway.send(new DebitAccountCommand(
				request.getAccountId(),
				request.getAmount(),
				request.getCurrency()
				
				));
		return commandResponse;
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> exceptionHandler(Exception exception) {
		
		ResponseEntity<String> entity = new ResponseEntity<>(
				exception.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR
				);
		return entity;
		
	}
	
	@GetMapping("/eventStore/{accountId}")
	public Stream eventStore(@PathVariable String accountId) {
		return eventStore.readEvents(accountId).asStream();
	}

}
