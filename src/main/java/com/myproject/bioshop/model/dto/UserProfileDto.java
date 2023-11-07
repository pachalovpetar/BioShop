package com.myproject.bioshop.model.dto;

import com.myproject.bioshop.model.entity.Role;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
public class UserProfileDto {

    private Long id;

    private String firstName;

    private String lastName;

    private List<Role> authorities;

    private String email;

    public Long getId() {
        return id;
    }

    public UserProfileDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserProfileDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserProfileDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public List<Role> getAuthorities() {
        return authorities;
    }

    public UserProfileDto setAuthorities(List<Role> authorities) {
        this.authorities = authorities;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserProfileDto setEmail(String email) {
        this.email = email;
        return this;
    }
}
