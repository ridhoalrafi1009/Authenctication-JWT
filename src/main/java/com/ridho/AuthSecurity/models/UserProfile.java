package com.ridho.AuthSecurity.models;

import org.springframework.data.relational.core.mapping.Table;

@Table("userProfile")
public class UserProfile {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String profil_image;

    public UserProfile(String email, String firstName, String lastName, String profil_image) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profil_image = profil_image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getProfil_image() {
        return profil_image;
    }

    public void setProfil_image(String profile_image) {
        this.profil_image = profile_image;
    }
}
