package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.CreditTransaction;

/**
 * 
 * Data Access Object for transaction access interface that extends JPA repository for database operations
 * @author omrawal
 *
 */

public interface CreditTransactionDAO extends JpaRepository<CreditTransaction, Integer> {

	// returns the next transaction id that need to be created
	@Query(value = "select MAX(trxn_id)+1 from credit_transaction",nativeQuery = true)
	int getNewTransactionID();
}
