package com.example.demo.BankService;

import com.example.demo.BankRepository.AccountRepository;
import com.example.demo.BankRepository.TransactionRepository;
import com.example.demo.Model.Account;
import com.example.demo.Model.Transaction;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
public class BankService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    private String generateAccountNumber() {
        return String.valueOf(1000000000L + new Random().nextInt(900000000));
    }

    public String openAccount(Account account) {
        account.setAccountNumber(generateAccountNumber());
        accountRepository.save(account);

        Transaction transaction = new Transaction("deposit", account.getBalance() , LocalDate.now() , account);
        transactionRepository.save(transaction);
        return "your account number : " + account.getAccountNumber();
    }

    @Transactional
    public void deposit(String accountNumber, double amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);

        Transaction transaction = new Transaction("deposit" , amount , LocalDate.now() , account);
        transactionRepository.save(transaction);
    }

    public void withdraw(String accountNumber, double amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            accountRepository.save(account);

            Transaction transaction = new Transaction("withdraw" , amount ,LocalDate.now() , account);
        } else {
            throw new RuntimeException("Insufficient balance");
        }
    }

    public void transfer(String fromAccount, String toAccount, double amount) {
        withdraw(fromAccount, amount);
        deposit(toAccount, amount);
    }

    public double showBalance(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber).getBalance();
    }

    public List<Transaction> accountStatement(String accountNumber) {
        return transactionRepository.findByAccount_AccountNumber(accountNumber);
    }
}
