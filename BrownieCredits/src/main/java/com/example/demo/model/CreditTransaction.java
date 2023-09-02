package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "credit_transaction")
public class CreditTransaction {
	
	@Id
	private int trxn_id;
	private int from_id;
	private int to_id;
	private int credits;
	private char type;
	
	public int getTrxn_id() {
		return trxn_id;
	}
	public void setTrxn_id(int trxn_id) {
		this.trxn_id = trxn_id;
	}
	public int getFrom_id() {
		return from_id;
	}
	public void setFrom_id(int from_id) {
		this.from_id = from_id;
	}
	public int getTo_id() {
		return to_id;
	}
	public void setTo_id(int to_id) {
		this.to_id = to_id;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Credit_Transaction [trxn_id=" + trxn_id + ", from_id=" + from_id + ", to_id=" + to_id + ", credits="
				+ credits + ", type=" + type + "]";
	}
	
}
