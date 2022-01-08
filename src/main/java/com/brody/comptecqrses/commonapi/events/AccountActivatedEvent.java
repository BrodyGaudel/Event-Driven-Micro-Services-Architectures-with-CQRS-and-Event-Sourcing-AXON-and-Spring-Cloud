package com.brody.comptecqrses.commonapi.events;

import com.brody.comptecqrses.commonapi.enums.AccountStatus;

public class AccountActivatedEvent extends BaseEvent<String> {
	
	private AccountStatus status;

	public AccountActivatedEvent(String id, AccountStatus status) {
		super(id);
		this.status = status;
	}

	public AccountStatus getStatus() {
		return status;
	}
	
	

}
