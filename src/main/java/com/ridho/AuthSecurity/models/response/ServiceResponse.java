package com.ridho.AuthSecurity.models.response;

public class ServiceResponse {
    private String service_code;
    private String service_name;
    private String service_icon;
    private Integer service_tarif;

    public ServiceResponse(String service_code, String service_name, String service_icon, Integer service_tarif) {
        this.service_code = service_code;
        this.service_name = service_name;
        this.service_icon = service_icon;
        this.service_tarif = service_tarif;
    }

    public String getservice_code() {
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

    public String geService_icon() {
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
