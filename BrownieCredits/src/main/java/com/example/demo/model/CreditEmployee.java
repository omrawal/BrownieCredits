package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "credit_employee")
public class CreditEmployee {
	@Id
	private int employee_id;
	private String name;
	private String email;
	private String designation;
	private int open_credits;
	private int received_credits;
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getOpen_credits() {
		return open_credits;
	}
	public void setOpen_credits(int open_credits) {
		this.open_credits = open_credits;
	}
	public int getReceived_credits() {
		return received_credits;
	}
	public void setReceived_credits(int received_credits) {
		this.received_credits = received_credits;
	}
	@Override
	public String toString() {
		return "Credit_Employee [employee_id=" + employee_id + ", name=" + name + ", email=" + email + ", designation="
				+ designation + ", open_credits=" + open_credits + ", received_credits=" + received_credits + "]";
	}
	
}
