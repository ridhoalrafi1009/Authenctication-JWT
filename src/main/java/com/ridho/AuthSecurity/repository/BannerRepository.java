package com.ridho.AuthSecurity.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ridho.AuthSecurity.models.Banner;
import com.ridho.AuthSecurity.models.response.BannerResponse;

@Repository
public class BannerRepository {
    private final JdbcTemplate jdbcTemplate;

    public BannerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<BannerResponse> getAllBanners() {
        return jdbcTemplate.query(
                "SELECT bannerName, bannerImage, description FROM banner",
                (rs, rowNum) -> {
                    BannerResponse banner = new BannerResponse(rs.getString("bannerName"), rs.getString("bannerImage"),
                            rs.getString("description"));
                    return banner;
                });
    }
}