package com.example.springbootproject.repository;

import com.example.springbootproject.configuration.DatabaseConfig;
import com.example.springbootproject.model.BankAccount;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankAccountDao {

    public static List<BankAccount> getAll() {
        Connection connection = DatabaseConfig.connection;
        List<BankAccount> bankAccountList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM bank_account")) {
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                Integer amount = resultSet.getInt("amount");

                BankAccount bankAccount = new BankAccount();
                bankAccount.setId(id);
                bankAccount.setAmount(amount);
                bankAccountList.add(bankAccount);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bankAccountList;
    }

    public static BankAccount getById(Integer id) {
        Connection connection = DatabaseConfig.connection;
        BankAccount bankAccount = new BankAccount();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM bank_account WHERE id = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Integer bankAccountId = resultSet.getInt("id");
                    Integer amount = resultSet.getInt("amount");

                    bankAccount.setId(bankAccountId);
                    bankAccount.setAmount(amount);
                    return bankAccount;
                }
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
