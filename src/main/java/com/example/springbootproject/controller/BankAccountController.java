package com.example.springbootproject.controller;

import com.example.springbootproject.model.BankAccount;
import com.example.springbootproject.service.BankAccountServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/bank-account")
@AllArgsConstructor
public class BankAccountController {

    private final BankAccountServiceImpl bankAccountService;

    @GetMapping()
    public Map<Integer, Integer> getAll() {
        return bankAccountService.getAllAccount();
    }

    @GetMapping("/{accountId}")
    public Integer getBalanceById(@PathVariable Integer accountId) {
        return BankAccountServiceImpl.getAccountById(accountId);
    }

    @PostMapping("/add")
    public void addNewBankAccount(@RequestBody BankAccount bankAccount) {
        bankAccountService.addNewBankAccount(bankAccount.getId(), bankAccount.getAmount());
    }

}
