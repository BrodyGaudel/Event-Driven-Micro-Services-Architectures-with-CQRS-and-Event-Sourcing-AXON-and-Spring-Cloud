package com.brody.comptecqrses.query.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brody.comptecqrses.query.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {

}
