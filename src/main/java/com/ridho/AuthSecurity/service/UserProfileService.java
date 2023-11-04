package com.ridho.AuthSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ridho.AuthSecurity.models.UserProfile;
import com.ridho.AuthSecurity.repository.JdbcUserProfileRepository;

@Service
public class UserProfileService {
    private final JdbcUserProfileRepository userProfileRepository;

    @Autowired
    public UserProfileService(JdbcUserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    public UserProfile getProfileByEmail(String email) {
        return userProfileRepository.getProfileByEmail(email);
    }

    public void saveUserProfile(UserProfile userProfile) {
        userProfileRepository.updateUserProfile(userProfile);
    }
}
