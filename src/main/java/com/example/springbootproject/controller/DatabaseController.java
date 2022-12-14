package com.example.springbootproject.controller;

import com.example.springbootproject.model.BankAccount;
import com.example.springbootproject.repository.BankAccountDao;
import com.example.springbootproject.service.DatabaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/database")
public class DatabaseController {

    @GetMapping()
    public List<BankAccount> getAll() {
        return BankAccountDao.getAll();
    }

    @GetMapping("/{id}")
    public BankAccount getById(@PathVariable Integer id) {
        return DatabaseService.getById(id);
    }
}
