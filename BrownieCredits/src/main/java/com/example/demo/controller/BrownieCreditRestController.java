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
	
	@PostMapping(path = "/createCreditTransaction")
	public String createCreditTransaction(@RequestBody CreditTransaction creditTransaction) {
//		return "Not yet implemented";
		System.out.println(creditTransaction);
		if(creditTransaction.getTrxn_id() == -1) {
			return "Request body has missing parameters";
		}
		// *** creditEmployee table ***
		// if from_id and to_id exist
		else if(!employee_dao.existsById(creditTransaction.getFrom_id())) {
			return "Sender is not present in Database";
		}
		else if (!employee_dao.existsById(creditTransaction.getTo_id())) {
			return "Receiver is not present in Database";
		}
		// if from_id has the open_credits available to transfer
		else if(employee_dao.getById(creditTransaction.getFrom_id()).getOpen_credits() < creditTransaction.getCredits()){
			return "User has insufficient credits to transfer";
		}
		// add them to received credits of to_id
		else {
			CreditEmployee sender = employee_dao.getById(creditTransaction.getFrom_id());
			CreditEmployee receiver = employee_dao.getById(creditTransaction.getTo_id());
			int credits = creditTransaction.getCredits();
			sender.setOpen_credits(sender.getOpen_credits()-credits);
			receiver.setReceived_credits(receiver.getReceived_credits()+credits);
			employee_dao.save(sender);
			employee_dao.save(receiver);
			// *** creditTransaction table ***
			// populate all details in transaction table trxn_type = "T"
			creditTransaction.setTrxn_type('T');
			
			transaction_dao.save(creditTransaction);
			return "Transaction successful";
		}
		
	}
	
	
	@PostMapping(path = "/createCreditRedemption")
	public String createCreditRedemption(@RequestBody CreditTransaction creditRedemption) {
		
//		return "Not yet implemented";
		System.out.println(creditRedemption);
		if(creditRedemption.getTrxn_id() == -1) {
			return "Request body has missing parameters";
		}
		// *** creditEmployee table ***
		// if from_id exist
		else if(!employee_dao.existsById(creditRedemption.getFrom_id())) {
			return "User is not present in Database";
		}
		// if from_id has the received_credits available to redeem
		else if(employee_dao.getById(creditRedemption.getFrom_id()).getReceived_credits() < creditRedemption.getCredits()){
			return "User has insufficient credits to redeem";
		}
		// add them to received credits of to_id
		else {
			CreditEmployee sender = employee_dao.getById(creditRedemption.getFrom_id());
			int credits = creditRedemption.getCredits();
			sender.setReceived_credits(sender.getReceived_credits()-credits);
			employee_dao.save(sender);
			
			// *** creditTransaction table ***
			// set to_id as -1 for admin's id in case of redemption
			// populate all details in transaction table current timestamp and trxn_type = "R"
			creditRedemption.setTo_id(-1);
			creditRedemption.setTrxn_type('R');
			transaction_dao.save(creditRedemption);
			return "Redemption successful";
			
		}	
		
	}
	
	
	 
	
}
