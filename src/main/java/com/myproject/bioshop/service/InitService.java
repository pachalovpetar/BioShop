package com.myproject.bioshop.service;

import com.myproject.bioshop.model.entity.Role;
import com.myproject.bioshop.model.enums.RoleType;
import com.myproject.bioshop.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class InitService {

    private final RoleService roleService;
    private final ModelMapper modelMapper;
    private final RoleRepository roleRepository;
    @Autowired
    public InitService(RoleService roleService, ModelMapper modelMapper, RoleRepository roleRepository) {
        this.roleService = roleService;
        this.modelMapper = modelMapper;
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    private void postConstruct() {
        init();
    }

    public void init() {
        if(roleRepository.count() == 0) {
            Arrays.stream(RoleType.values()).map(this::convert).forEach(this.roleRepository::saveAndFlush);
        }

    }

    public Role convert(RoleType roleType) {
        return new Role().setRole(roleType);
    }

}
