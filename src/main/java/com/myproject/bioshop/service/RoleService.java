package com.myproject.bioshop.service;

import com.myproject.bioshop.model.entity.Role;
import com.myproject.bioshop.model.enums.RoleType;
import com.myproject.bioshop.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    public RoleService(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    public List<Role> findAllRoles() {
        return this.roleRepository.findAll();
    }

    public Role findByAuthority(String authority) {
        return this.roleRepository.findByRole(authority);
    }

    public void initRoles() {
        Arrays.stream(RoleType.values())
                .map(r -> this.modelMapper
                        .map(r, Role.class))
                .forEach(this.roleRepository::saveAndFlush);

        System.out.println();

    }


}
