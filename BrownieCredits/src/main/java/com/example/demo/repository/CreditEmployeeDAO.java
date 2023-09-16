package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.CreditEmployee;

/**
 * 
 * Data Access Object for employee access interface that extends JPA repository for database operations
 * @author omrawal
 *
 */

public interface CreditEmployeeDAO extends JpaRepository<CreditEmployee, Integer> {
	
	// returns the next employee id that need to be created
	@Query(value = "select MAX(employee_id)+1 from credit_employee",nativeQuery = true)
	int getNewEmployeeID();
	
	// returns list of all employee ids
	@Query(value = "select employee_id from credit_employee",nativeQuery = true)
	List<Integer> getAllEmployeeId();
	
	
	
}
