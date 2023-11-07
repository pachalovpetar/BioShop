package com.myproject.bioshop.model.entity;

import com.myproject.bioshop.model.enums.ProductType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull
    private ProductType type;

    public Long getId() {
        return id;
    }

    public Category setId(Long id) {
        this.id = id;
        return this;
    }

    public ProductType getType() {
        return type;
    }

    public Category setType(ProductType type) {
        this.type = type;
        return this;
    }
}
