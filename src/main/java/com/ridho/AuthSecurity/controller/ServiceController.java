package com.ridho.AuthSecurity.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ridho.AuthSecurity.models.response.ServiceResponse;
import com.ridho.AuthSecurity.service.ServiceService;

@RestController
@RequestMapping("/service")
public class ServiceController {

    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping
    public List<ServiceResponse> getBanners() {
        return serviceService.getAllBanners();
    }
}
