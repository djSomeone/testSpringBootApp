package com.first_spring_boot_project.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import io.github.cdimascio.dotenv.Dotenv;

@Configuration
public class DatabaseConfig {
    private static final Dotenv dotenv=Dotenv.load();

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    // Access environment variables via dotenv
    public String getDatabaseUrl() {
        return dotenv.get("DB_URL");
    }

    public String getDatabaseUserName() {
        return dotenv.get("DB_USERNAME");
    }

    public String getDatabasePassword() {
        return dotenv.get("DB_PASSWORD");
    }
}
