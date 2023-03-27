package com.myproject.bioshop.repository;

import com.myproject.bioshop.model.entity.Category;
import com.myproject.bioshop.model.enums.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findCategoryByType(ProductType type);
}
