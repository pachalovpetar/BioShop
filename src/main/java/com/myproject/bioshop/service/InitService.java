package com.myproject.bioshop.service;

import com.myproject.bioshop.model.entity.Category;
import com.myproject.bioshop.model.entity.Role;
import com.myproject.bioshop.model.enums.ProductType;
import com.myproject.bioshop.model.enums.RoleType;
import com.myproject.bioshop.repository.CategoryRepository;
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

    private final CategoryRepository categoryRepository;
    @Autowired
    public InitService(RoleService roleService, ModelMapper modelMapper, RoleRepository roleRepository, CategoryRepository categoryRepository) {
        this.roleService = roleService;
        this.modelMapper = modelMapper;
        this.roleRepository = roleRepository;
        this.categoryRepository = categoryRepository;

    }

    @PostConstruct
    private void postConstruct() {
        init();
        initCategories();
    }

    public void init() {
        if(roleRepository.count() == 0) {
            Arrays.stream(RoleType.values())
                    .map(this::convert)
                    .forEach(this.roleRepository::saveAndFlush);
        }

    }

    public void initCategories() {
        if(this.categoryRepository.count() == 0) {
            Arrays.stream(ProductType.values())
                    .map(this::convertToCategory)
                    .forEach(this.categoryRepository::saveAndFlush);
        }
    }

    public Role convert(RoleType roleType) {
        return new Role().setRole(roleType);
    }

    public Category convertToCategory(ProductType productType) {

        return new Category().setType(productType);
    }
}
