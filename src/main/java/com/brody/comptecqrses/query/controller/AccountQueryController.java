package com.brody.comptecqrses.query.controller;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brody.comptecqrses.commonapi.dtos.AccountDTO;
import com.brody.comptecqrses.commonapi.dtos.OperationDTO;
import com.brody.comptecqrses.commonapi.queries.GetAccountByIdQuery;
import com.brody.comptecqrses.commonapi.queries.GetAllAccountQuery;
import com.brody.comptecqrses.commonapi.queries.GetAllOperationQuery;
import com.brody.comptecqrses.query.entities.Account;
import com.brody.comptecqrses.query.entities.Operation;

@RestController
@RequestMapping(path = "/query/accounts/")
public class AccountQueryController {
	
	private QueryGateway queryGateway;

	public AccountQueryController(QueryGateway queryGateway) {
		this.queryGateway = queryGateway;
	}
	
	@GetMapping("/allAccounts")
	@ResponseBody
	public List<AccountDTO> accountList() {
		List<Account> response = queryGateway.query(new GetAllAccountQuery(), ResponseTypes.multipleInstancesOf(Account.class)).join();
		List<Operation> listOfOps= queryGateway.query(new GetAllOperationQuery(), ResponseTypes.multipleInstancesOf(Operation.class)).join();
		
		List<AccountDTO> allAccounts = new ArrayList<>();
		for(Account a: response) {
			AccountDTO adto = new AccountDTO();
			adto.setBalance(a.getBalance());
			adto.setCurrency(a.getCurrency());
			adto.setId(a.getId());
			adto.setStatus(a.getStatus());
			
			List<OperationDTO> allOperations = new ArrayList<>();
			for(Operation op: listOfOps) {
				if(op.getAccount().getId().equals(a.getId())) {
					
					OperationDTO odto = new OperationDTO();
					odto.setAmount(op.getAmount());
					odto.setDate(op.getDate());
					odto.setId(op.getId());
					odto.setType(op.getType());
					allOperations.add(odto);
					allOperations.add(odto);
				}
			}
			
			
			adto.setOperationsDTO(allOperations);
			allAccounts.add(adto);
		}
			
		return allAccounts;	
	}
	
	
	@GetMapping("/getbyid/{id}")
	@ResponseBody
	public AccountDTO getAccount(@PathVariable String id) {
		Account a = queryGateway.query(new GetAccountByIdQuery(id), ResponseTypes.instanceOf(Account.class)).join();
		List<Operation> listOfOps= queryGateway.query(new GetAllOperationQuery(), ResponseTypes.multipleInstancesOf(Operation.class)).join();
		
		AccountDTO adto = new AccountDTO();
		adto.setBalance(a.getBalance());
		adto.setCurrency(a.getCurrency());
		adto.setId(a.getId());
		adto.setStatus(a.getStatus());
		
		List<OperationDTO> allOperations = new ArrayList<>();
		for(Operation op: listOfOps) {
			if(op.getAccount().getId().equals(a.getId())) {
				
				OperationDTO odto = new OperationDTO();
				odto.setAmount(op.getAmount());
				odto.setDate(op.getDate());
				odto.setId(op.getId());
				odto.setType(op.getType());
				allOperations.add(odto);
				allOperations.add(odto);
			}
		}
		adto.setOperationsDTO(allOperations);
		return adto;
		
	}
	

}
