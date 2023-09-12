package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.CreditTransaction;

public interface CreditTransactionDAO extends JpaRepository<CreditTransaction, Integer> {

	@Query(value = "select MAX(trxn_id)+1 from credit_transaction",nativeQuery = true)
	int getNewTransactionID();
}
