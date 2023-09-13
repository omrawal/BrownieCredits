package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.CreditEmployee;

public interface CreditEmployeeDAO extends JpaRepository<CreditEmployee, Integer> {
	
	@Query(value = "select MAX(employee_id)+1 from credit_employee",nativeQuery = true)
	int getNewEmployeeID();
	
	@Query(value = "update credit_employee set open_credits = open_credits + :credit;",nativeQuery = true)
	void disburseCredits(@Param("credit") int credit);
	
	@Query(value = "select employee_id from credit_employee",nativeQuery = true)
	List<Integer> getAllEmployeeId();
	
	
	
}
