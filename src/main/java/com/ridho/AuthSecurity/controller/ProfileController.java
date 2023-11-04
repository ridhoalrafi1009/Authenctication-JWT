package com.ridho.AuthSecurity.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.ridho.AuthSecurity.models.UserProfile;

@RestController
public class ProfileController {

    @GetMapping("/private")
    public ResponseEntity<Map<String, Object>> getProfile(@RequestHeader("Authorization") String authorizationHeader) {

        String token = extractTokenFromHeader(authorizationHeader);

        if (token == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("status", 108);
            response.put("message", "Token tidak valid atau kadaluwarsa");
            response.put("data", null);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        String email = decodeTokenAndGetEmail(token);

        UserProfile userProfile = getProfileInfo(email);

        if (userProfile != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("status", 0);
            response.put("message", "Sukses");
            response.put("data", userProfile);
            return ResponseEntity.ok(response);
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("status", 108);
            response.put("message", "Token tidak valid atau kadaluwarsa");
            response.put("data", null);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

    }

    private String extractTokenFromHeader(String authorizationHeader) {
        // Mengambil token dari header Authorization (Bearer Token)
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7);
        }
        return null;
    }

    private String decodeTokenAndGetEmail(String token) {
        return "ridho@gmail.com";
    }

    private UserProfile getProfileInfo(String email) {
        return new UserProfile(email, "ridho", "alrafi", "https://yoururlapi.com/profile.jpeg");
    }
}