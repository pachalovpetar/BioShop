package com.myproject.bioshop.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;


import java.util.List;
import java.util.Set;


@NoArgsConstructor
@Entity
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 12)
    @Column(nullable = false)
    private String firstName;

    @Size(min = 3, max = 12)
    @Column(nullable = false)
    private String lastName;

    @Email
    @Column(nullable = false)
    private String email;


    @Column(nullable = false)
    private String password;


    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> authorities;

    @OneToMany
    private Set<Order> orders;

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<Role> getAuthorities() {
        return authorities;
    }

    public User setAuthorities(List<Role> authorities) {
        this.authorities = authorities;
        return this;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public User setOrders(Set<Order> orders) {
        this.orders = orders;
        return this;
    }
}
