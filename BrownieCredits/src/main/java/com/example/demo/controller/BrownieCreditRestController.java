package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CreditEmployee;
import com.example.demo.model.CreditTransaction;
import com.example.demo.repository.CreditEmployeeDAO;
import com.example.demo.repository.CreditTransactionDAO;

@RestController
public class BrownieCreditRestController {
	@Autowired
	CreditEmployeeDAO employee_dao;
	
	@Autowired
	CreditTransactionDAO transaction_dao;
	
	@GetMapping(path = "/getAllEmployees")
	public List<CreditEmployee>getAllEmployees(){
		return employee_dao.findAll();
	}
	
	@GetMapping(path = "/getAllTransactions")
	public List<CreditTransaction>getAllTransactions(){
		return transaction_dao.findAll();
	}
	
	
	
}
