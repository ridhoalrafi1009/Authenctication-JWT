package com.ridho.AuthSecurity.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ridho.AuthSecurity.models.response.ServiceResponse;
import com.ridho.AuthSecurity.repository.ServiceRepository;

@Service
public class ServiceService {
    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<ServiceResponse> getAllBanners() {
        return serviceRepository.getAllBanners();
    }
}
