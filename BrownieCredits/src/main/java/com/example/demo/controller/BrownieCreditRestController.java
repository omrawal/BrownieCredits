package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping(path = "/createEmployee")
	public String createEmployee(@RequestBody CreditEmployee emp) {
		if(employee_dao.existsById(emp.getEmployee_id())) {
			return "Employee with employee id " + emp.getEmployee_id() + " Already exists";
		}
		else {
			try {
				System.out.println(emp);
				employee_dao.save(emp);
				return "Employee created Successfully";
			}
			catch (Exception exception){
				return exception.toString();
			}
		}
		
	}
	
	@DeleteMapping(path = "/deleteEmployee/{emp_id}")
	public String deleteEmployee(@PathVariable int emp_id) {
		if(employee_dao.existsById(emp_id)) {
			try {
				employee_dao.deleteById(emp_id);
				return "Employee deleted Successfully";
			}
			catch (Exception exception){
				return exception.toString();
			}
		}
		else {
			return "Employee with employee id "+emp_id+ " does not exist";
		}
		
	}
	
	@PutMapping(path = "/updateEmployee")
	public String updateEmployee(@RequestBody CreditEmployee emp) {
		if(employee_dao.existsById(emp.getEmployee_id())) {
			try {
				employee_dao.save(emp);
				return "Employee updated Successfully";
			}
			catch (Exception exception){
				return exception.toString();
			}
		}
		else {
			return "Employee with employee id "+emp.getEmployee_id()+ " does not exist";
		}
	}
	
	
	 
	
}
