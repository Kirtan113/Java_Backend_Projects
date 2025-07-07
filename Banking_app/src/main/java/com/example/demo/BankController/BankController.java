package com.example.demo.BankController;

import com.example.demo.BankService.BankService;
import com.example.demo.DTO.AmountRequest;
import com.example.demo.DTO.AmountTransferData;
import com.example.demo.Model.Account;
import com.example.demo.Model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping("/open")
    public String openAccount(@RequestBody Account account) {
        return bankService.openAccount(account);
    }

    @PostMapping("/deposit")
    public void deposit(@RequestBody AmountRequest amountRequest) {
        bankService.deposit(amountRequest.getAccountNumber(), amountRequest.getAmount());
    }

    @PostMapping("/withdraw")
    public void withdraw(@RequestBody AmountRequest amountRequest) {
        bankService.withdraw(amountRequest.getAccountNumber(), amountRequest.getAmount());
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody AmountTransferData amountTransferData) {
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa"+account.getAccountNumber());
        bankService.transfer(amountTransferData.getFromAccount(), amountTransferData.getToAccount(), amountTransferData.getAmount());
    }

    @GetMapping("/balance")
    public double showBalance(@RequestBody AmountRequest amountRequest) {
            return bankService.showBalance(amountRequest.getAccountNumber());
    }

    @GetMapping("/statement")
    public List<Transaction> getStatement(@RequestBody AmountRequest amountRequest) {
        System.out.println("Account Number:++++++++++++++"+ amountRequest.getAccountNumber());
        return bankService.accountStatement(amountRequest.getAccountNumber());
    }

}
