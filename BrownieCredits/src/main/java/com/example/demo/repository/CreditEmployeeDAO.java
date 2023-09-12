package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.CreditEmployee;

public interface CreditEmployeeDAO extends JpaRepository<CreditEmployee, Integer> {
	
	@Query(value = "select MAX(employee_id)+1 from credit_employee",nativeQuery = true)
	int getNewEmployeeID();
}
