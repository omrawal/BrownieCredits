package com.example.demo.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * 
 * This class refers to the table credit_transaction that stored all transaction of credits
 * including Disbursement, Redemption and Transaction 
 * @author omrawal
 *
 */


@Entity(name = "credit_transaction")
public class CreditTransaction {
	
	@Id
	private int trxn_id = -1;
	private int from_id;
	private int to_id;
	private int credits;
	private char trxn_type;
	private String transaction_timestamp;
	private String trxn_comment;
	
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
	public char getTrxn_type() {
		return trxn_type;
	}
	public void setTrxn_type(char trxn_type) {
		this.trxn_type = trxn_type;
	}
	public String getTrxn_comment() {
		return trxn_comment;
	}
	public void setTrxn_comment(String trxn_comment) {
		this.trxn_comment = trxn_comment;
	}
	public String getTransaction_timestamp() {
		return transaction_timestamp;
	}
	public void setTransaction_timestamp(String transaction_timestamp) {
		this.transaction_timestamp = transaction_timestamp;
		this.transaction_timestamp = new Timestamp(System.currentTimeMillis()).toString();
	}
	@Override
	public String toString() {
		return "CreditTransaction [trxn_id=" + trxn_id + ", from_id=" + from_id + ", to_id=" + to_id + ", credits="
				+ credits + ", trxn_type=" + trxn_type + ", transaction_timestamp=" + transaction_timestamp
				+ ", trxn_comment=" + trxn_comment + "]";
	}
	
	
}
