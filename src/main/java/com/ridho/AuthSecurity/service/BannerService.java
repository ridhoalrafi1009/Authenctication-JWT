package com.ridho.AuthSecurity.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ridho.AuthSecurity.models.response.BannerResponse;
import com.ridho.AuthSecurity.repository.BannerRepository;

@Service
public class BannerService {
    private final BannerRepository bannerRepository;

    public BannerService(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }

    public List<BannerResponse> getAllBanners() {
        return bannerRepository.getAllBanners();
    }
}
