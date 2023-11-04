package com.ridho.AuthSecurity.repository;

import java.util.Optional;

import com.ridho.AuthSecurity.models.User;

public interface UserRepository {
    Optional<User> findByEmail(String email);

    int save(User user);
}
