package com.ridho.AuthSecurity.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ridho.AuthSecurity.models.response.ServiceResponse;

@Repository
public class ServiceRepository {
    private final JdbcTemplate jdbcTemplate;

    public ServiceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ServiceResponse> getAllBanners() {
        return jdbcTemplate.query(
                "SELECT service_code, service_name, service_icon, service_tarif FROM service",
                (rs, rowNum) -> {
                    ServiceResponse banner = new ServiceResponse(rs.getString("service_code"),
                            rs.getString("service_name"),
                            rs.getString("service_icon"), rs.getInt("service_tarif"));
                    return banner;
                });
    }
}
