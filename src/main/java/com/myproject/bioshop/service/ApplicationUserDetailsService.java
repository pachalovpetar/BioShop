package com.myproject.bioshop.service;

import com.myproject.bioshop.model.AppUserDetails;
import com.myproject.bioshop.model.entity.Role;
import com.myproject.bioshop.model.entity.User;
import com.myproject.bioshop.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


public class ApplicationUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;


    public ApplicationUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findUserByEmail(username)
                .map(this::map)
                .orElseThrow(() -> new UsernameNotFoundException("User with email "+ username + " not found!"));
    }


    private UserDetails map(User user) {
        return new AppUserDetails(
                user.getEmail(),
                user.getPassword(),
                extractAuthorities(user)
        )
                .setFullName(user.getFirstName() + " " + user.getLastName());
    }



    private List<GrantedAuthority> extractAuthorities(User user) {
        return user.getAuthorities()
                .stream()
                .map(this::mapRole)
                .toList();
    }

    private GrantedAuthority mapRole(Role role) {
        return new SimpleGrantedAuthority("ROLE_" + role.getRole().name());
    }

}
