package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CreditTransaction;

public interface CreditTransactionDAO extends JpaRepository<CreditTransaction, Integer> {

}
