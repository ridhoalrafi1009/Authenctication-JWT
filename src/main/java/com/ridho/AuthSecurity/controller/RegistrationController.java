package com.ridho.AuthSecurity.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ridho.AuthSecurity.models.request.RegistrationRequest;
import com.ridho.AuthSecurity.service.UserService;

@RestController
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public ResponseEntity<Map<String, Object>> register(@RequestBody RegistrationRequest request) {
        Map<String, Object> response = new HashMap<>();

        if (!isValidEmail(request.getEmail())) {
            response.put("status", 102);
            response.put("message", "Parameter email tidak sesuai format");
            response.put("data", null);
            return ResponseEntity.badRequest().body(response);
        }

        if (request.getPassword().length() < 8) {
            response.put("status", 103);
            response.put("message", "Panjang password kurang dari 8 karakter");
            response.put("data", null);
            return ResponseEntity.badRequest().body(response);
        }

        userService.registerUser(request.getEmail(), request.getFirstName(), request.getLastName(),
                request.getPassword());

        response.put("status", 0);
        response.put("message", "Registrasi berhasil silahkan login");
        response.put("data", null);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/registration")
    public ResponseEntity<String> getRegistrationPage() {
        return ResponseEntity.ok("Ini adalah halaman pendaftaran.");
    }

    private boolean isValidEmail(String email) {
        // Validasi format email menggunakan ekspresi reguler
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(regex);
    }
}
