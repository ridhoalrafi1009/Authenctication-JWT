package com.ridho.AuthSecurity.repository;

import java.util.Optional;

import com.ridho.AuthSecurity.models.User;
import com.ridho.AuthSecurity.models.UserProfile;

public interface UserProfileRepository {
    Optional<User> findByEmail(String email);

    int save(UserProfile userProfile);
}
