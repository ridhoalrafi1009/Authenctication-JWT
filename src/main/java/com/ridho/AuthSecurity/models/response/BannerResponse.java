package com.ridho.AuthSecurity.models.response;

public class BannerResponse {
    private String banner_name;
    private String banner_image;
    private String description;

    public BannerResponse(String bannerName, String bannerImage, String description) {
        this.banner_name = bannerName;
        this.banner_image = bannerImage;
        this.description = description;
    }

    public String getBanner_name() {
        return banner_name;
    }

    public void setBanner_name(String bannerName) {
        this.banner_name = bannerName;
    }

    public String getBanner_image() {
        return banner_image;
    }

    public void setBanner_image(String bannerImage) {
        this.banner_image = bannerImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
