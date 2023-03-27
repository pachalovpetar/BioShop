package com.myproject.bioshop.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class AppUserDetails extends User {

    private String fullName;

    public AppUserDetails(String email, String password,
                          Collection<? extends GrantedAuthority> authorities) {
        super(email, password, authorities);
    }

    public String getFullName() {
        return fullName;
    }

    public AppUserDetails setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }
}
