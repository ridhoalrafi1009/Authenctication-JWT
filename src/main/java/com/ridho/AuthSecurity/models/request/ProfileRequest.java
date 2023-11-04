package com.ridho.AuthSecurity.models.request;

public class ProfileRequest {
    private String email;
    private String firstName;
    private String lastName;
    private String profil_image;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfil_Image() {
        return profil_image;
    }

    public void setProfil_image(String profil_image) {
        this.profil_image = profil_image;
    }

}
