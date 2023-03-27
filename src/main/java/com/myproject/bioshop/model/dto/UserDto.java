package com.myproject.bioshop.model.dto;

import com.myproject.bioshop.model.entity.Order;
import com.myproject.bioshop.model.entity.Role;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Set;

public class UserDto {

    @Size(min = 3, max = 12)
    private String firstName;

    @Size(min = 3, max = 12)
    private String lastName;

    @Email
    private String email;

    private List<Role> authorities;

    private Set<Order> orders;
}
