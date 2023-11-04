package com.ridho.AuthSecurity.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ridho.AuthSecurity.models.request.LoginRequest;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@RestController
public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest request) {
        Map<String, Object> response = new HashMap<>();

        // Validasi email
        if (!isValidEmail(request.getEmail())) {
            response.put("status", 102);
            response.put("message", "Parameter email tidak sesuai format");
            response.put("data", null);
            return ResponseEntity.badRequest().body(response);
        }

        // Validasi panjang password
        if (request.getPassword().length() < 8) {
            response.put("status", 103);
            response.put("message", "Panjang password kurang dari 8 karakter");
            response.put("data", null);
            return ResponseEntity.badRequest().body(response);
        }

        boolean authenticationSuccess = authenticateUser(request.getEmail(), request.getPassword());

        if (authenticationSuccess) {
            // Generate JWT token
            String token = generateJwtToken(request.getEmail());

            response.put("status", 0);
            response.put("message", "Login Sukses");
            response.put("token", token);
            return ResponseEntity.ok(response);
        } else {
            response.put("status", 103);
            response.put("message", "Username atau password salah");
            return ResponseEntity.status(401).body(response);
        }
    }

    @GetMapping("/login")
    public ResponseEntity<String> getLoginPage() {
        // Di sini, Anda dapat mengembalikan halaman HTML atau pesan yang sesuai
        return ResponseEntity.ok("Ini adalah halaman login.");
    }

    private boolean isValidEmail(String email) {

        return true;
    }

    private boolean authenticateUser(String email, String password) {

        return true;
    }

    private String generateJwtToken(String email) {
        // Generate JWT token dengan payload email dan expiration selama 12 jam
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        String token = Jwts.builder()
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + 12 * 60 * 60 * 1000))
                .signWith(key)
                .compact();
        return token;
    }
}
