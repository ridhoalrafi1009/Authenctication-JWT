package com.ridho.AuthSecurity.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ridho.AuthSecurity.models.response.BannerResponse;
import com.ridho.AuthSecurity.service.BannerService;

@RestController
@RequestMapping("/banner")
public class BannerController {

    private final BannerService bannerService;

    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @GetMapping
    public List<BannerResponse> getBanners() {
        return bannerService.getAllBanners();
    }
}
