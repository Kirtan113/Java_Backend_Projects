package com.example.demo.BankRepository;

import com.example.demo.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account , Long> {
    Account findByAccountNumber(String accountNumber);
}
