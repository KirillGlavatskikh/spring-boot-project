package com.example.springbootproject.configuration;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Slf4j
@Component
public class DatabaseConfig {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.name}")
    private String name;

    @Value("${spring.datasource.password}")
    private String password;

    public static Connection connection;

    @PostConstruct
    void init() {
        Properties properties = new Properties();
        properties.setProperty("user", name);
        properties.setProperty("password", password);

        try {
            connection = DriverManager.getConnection(url, properties);
        } catch (SQLException e) {
            log.error("No connection");
        }
    }
}
