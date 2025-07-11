package com.example.demo.BankRepository;

import com.example.demo.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction , Long> {
    List<Transaction> findByAccount_AccountNumber(String accountNumber);
}
