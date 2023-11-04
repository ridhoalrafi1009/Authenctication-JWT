package com.ridho.AuthSecurity.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@EntityScan
@Table("banner")
public class Banner {
    @Id

    private Long id;
    private String bannerName;
    private String bannerImage;
    private String description;

    // Constructors, getters, and setters

    public Banner() {
        // Default constructor
    }

    public Banner(String bannerName, String bannerImage, String description) {
        this.bannerName = bannerName;
        this.bannerImage = bannerImage;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBannerName() {
        return bannerName;
    }

    public void setBannerName(String bannerName) {
        this.bannerName = bannerName;
    }

    public String getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
