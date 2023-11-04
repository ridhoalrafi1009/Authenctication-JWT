package com.ridho.AuthSecurity.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.ridho.AuthSecurity.models.UserProfile;
import com.ridho.AuthSecurity.models.request.ProfileUpdateRequest;
import com.ridho.AuthSecurity.service.UserProfileService;

@RestController
public class ProfileController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("/profile")
    public ResponseEntity<Map<String, Object>> getProfile(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails != null) {
            String email = userDetails.getUsername();
            String query = "SELECT email, firstName, lastName, profil_image FROM userprofile WHERE email = ?";
            Map<String, Object> result = jdbcTemplate.queryForMap(query, email);

            if (result.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            Map<String, Object> response = new HashMap<>();
            response.put("status", 0);
            response.put("message", "Sukses");
            response.put("data", result);
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
        if (token != null && token.startsWith("Bearer ")) {
            // Mengambil token tanpa "Bearer "
            token = token.substring(7);

            // Anda dapat memasukkan logika dekode sesuai kebutuhan Anda di sini.
            // Ini hanya contoh sederhana, dan Anda mungkin perlu menggunakan library JWT
            // atau algoritma enkripsi lainnya jika token Anda dienkripsi.

            // Contoh sederhana: Token hanya berisi email
            return token;
        }
        return null;
    }

    @PutMapping("/profile/update")
    public ResponseEntity<Map<String, Object>> updateProfile(
            @RequestHeader("Authorization") String authorizationHeader,
            @RequestBody ProfileUpdateRequest updateRequest) {

        String token = extractTokenFromHeader(authorizationHeader);

        if (token == null) {
            // Tangani kesalahan otorisasi
        }

        String email = decodeTokenAndGetEmail(token);

        UserProfile userProfile = new UserProfile(email, updateRequest.getFirstName(), updateRequest.getLastName(),
                updateRequest.getProfil_image());

        // Perbarui data profil dengan data dari updateRequest
        userProfile.setFirstName(updateRequest.getFirstName());
        userProfile.setLastName(updateRequest.getLastName());
        userProfile.setProfil_image(updateRequest.getProfil_image());

        // Simpan data profil yang diperbarui (misalnya, ke database)
        userProfileService.saveUserProfile(userProfile);

        Map<String, Object> response = new HashMap<>();
        response.put("status", 0);
        response.put("message", "Profil berhasil diperbarui");
        response.put("data", userProfile);

        return ResponseEntity.ok(response);
    }

}
