package com.example.springbootproject.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConstructorBinding;

@Data
@ConstructorBinding
public class BankAccount {
    private Integer id;
    private Integer amount;
}
