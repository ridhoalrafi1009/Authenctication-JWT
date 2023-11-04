package com.ridho.AuthSecurity.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ridho.AuthSecurity.models.UserProfile;

@Repository
public class JdbcUserProfileRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcUserProfileRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public UserProfile getProfileByEmail(String email) {
        String sql = "SELECT * FROM userprofile WHERE email = ?";
        RowMapper<UserProfile> rowMapper = new BeanPropertyRowMapper<>(UserProfile.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, email);
    }

    public void updateUserProfile(UserProfile userProfile) {
        String sql = "UPDATE userprofile SET firstName = ?, lastName = ?, profil_image = ? WHERE email = ?";
        jdbcTemplate.update(
                sql,
                userProfile.getFirstName(),
                userProfile.getLastName(),
                userProfile.getProfil_image(),
                userProfile.getEmail());
    }
}
