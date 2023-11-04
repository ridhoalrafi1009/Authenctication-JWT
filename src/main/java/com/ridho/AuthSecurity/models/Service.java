package com.ridho.AuthSecurity.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@EntityScan
@Table("service")
public class Service {
    @Id

    private Long id;
    private String service_code;
    private String service_name;
    private String service_icon;
    private Integer service_tarif;

    // Constructors, getters, and setters

    public Service() {
        // Default constructor
    }

    public Service(String service_code, String service_name, String service_icon, Integer service_tarif) {
        this.service_code = service_code;
        this.service_name = service_name;
        this.service_icon = service_icon;
        this.service_tarif = service_tarif;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getService_code() {
        return service_code;
    }

    public void setService_code(String service_code) {
        this.service_code = service_code;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getService_icon() {
        return service_icon;
    }

    public void setService_icon(String service_icon) {
        this.service_icon = service_icon;
    }

    public Integer getService_tarif() {
        return service_tarif;
    }

    public void setService_tarif(Integer service_tarif) {
        this.service_tarif = service_tarif;
    }
}
