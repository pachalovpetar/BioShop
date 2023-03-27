package com.myproject.bioshop.service;

import com.myproject.bioshop.model.entity.Category;
import com.myproject.bioshop.model.enums.ProductType;
import com.myproject.bioshop.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;


    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category getCategoryByType(ProductType type) {
        return this.categoryRepository
                .findCategoryByType(type)
                .orElseThrow(NoSuchElementException::new);
    }
}
