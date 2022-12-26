package com.example.springbootproject.service;

import com.example.springbootproject.model.BankAccount;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class BankAccountServiceImpl implements BankAccountService {


    public static Map<Integer, Integer> storageBankAccount = new HashMap<>();
    BankAccount bankAccount;

    public static Integer getAccountById(Integer accountId) {
        if (!storageBankAccount.containsKey(accountId)) {
            throw new IllegalArgumentException("Поля не заполнены");
        }
        if (accountId == null) {
            throw new NullPointerException();
        } else {
            return storageBankAccount.get(accountId);
        }
    }

    @PostConstruct
    public BankAccount init() {
        bankAccount = new BankAccount();
        bankAccount.setAmount(1000);
        bankAccount.setId(1);
        return bankAccount;
    }

    @PostConstruct
    public void addAccount() {
        storageBankAccount.put(bankAccount.getId(), bankAccount.getAmount());
    }

    public void addNewBankAccount(Integer id, Integer amount) {
        if (id == null || amount == null) {
            throw new NullPointerException();
        } else {
            storageBankAccount.put(id, amount);
        }
    }

    public Map<Integer, Integer> getAllAccount() {
        return storageBankAccount;
    }
}
