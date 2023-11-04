package com.ridho.AuthSecurity.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final JdbcTemplate jdbcTemplate;

    public UserService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void registerUser(String email, String firstName, String lastName, String password) {
        String sql = "INSERT INTO users (email, firstName, lastName, password) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, email, firstName, lastName, password);
    }
}
