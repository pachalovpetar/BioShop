package com.myproject.bioshop.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UserRegisterForm {

    @Size(min = 3, max = 12)
    private String firstName;

    @Size(min = 3, max = 12)
    private String lastName;

    @Email
    private String email;

    @Size(min = 5, max = 12)
    private String password;

    @Size(min = 5, max = 12)
    private String confirmPassword;

    public UserRegisterForm() {
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterForm setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterForm setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterForm setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterForm setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterForm setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
