package com.brody.comptecqrses.query.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brody.comptecqrses.query.entities.Account;

public interface AccountRepository extends JpaRepository<Account, String>{
	

}
