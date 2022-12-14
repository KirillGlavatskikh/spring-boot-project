package com.example.springbootproject.service;

import com.example.springbootproject.model.BankAccount;
import com.example.springbootproject.repository.BankAccountDao;

public class DatabaseService {
    public static BankAccount getById(Integer id) {
        return BankAccountDao.getById(id);
    }
}
