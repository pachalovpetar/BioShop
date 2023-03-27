package com.myproject.bioshop.service;

import com.myproject.bioshop.exceptions.NoSuchUserException;
import com.myproject.bioshop.model.dto.UserDto;
import com.myproject.bioshop.model.dto.UserRegisterForm;
import com.myproject.bioshop.model.entity.Role;
import com.myproject.bioshop.model.entity.User;
import com.myproject.bioshop.model.enums.RoleType;
import com.myproject.bioshop.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;


    @Autowired
    public UserService(UserRepository userRepository,
                       ModelMapper modelMapper,
                       PasswordEncoder passwordEncoder,
                       RoleService roleService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;

    }

    public void registerUser(UserRegisterForm userRegisterForm) {

        User user = this.modelMapper.map(userRegisterForm, User.class);
        user.setPassword(this.passwordEncoder.encode(userRegisterForm.getPassword()));

        if(this.userRepository.count() == 0) {
            user.setAuthorities(this.roleService.findAllRoles());
        } else {
            user.setAuthorities(new ArrayList<>());
            Role role = new Role();
            role.setRole(RoleType.USER);


            user.getAuthorities().add(role);
        }

        this.userRepository.saveAndFlush(user);
    }

    public UserDto getUserByEmail(String email) throws NoSuchUserException {

        return this.userRepository
                .findUserByEmail(email)
                .map(user -> this.modelMapper.map(user, UserDto.class))
                .orElseThrow(NoSuchUserException::new);
    }

    public void deleteUser(String email) {
        this.userRepository.deleteUserByEmail(email);
    }

    public List<UserDto> getAllUsers() {

        return this.userRepository
                .findAll()
                .stream()
                .map(user -> this.modelMapper.map(user, UserDto.class))
                .toList();
    }

    public void makeAdmin(String email) throws NoSuchUserException {

        User user = this.userRepository
                .findUserByEmail(email)
                .orElseThrow(NoSuchUserException::new);

        user.getAuthorities().add(this.roleService.findByAuthority("ROLE_ADMIN"));

        this.userRepository.saveAndFlush(user);
    }
}
