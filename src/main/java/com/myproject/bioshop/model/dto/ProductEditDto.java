package com.myproject.bioshop.model.dto;

import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
public class ProductEditDto {

    private Long id;

    private String name;

    private String description;

    private String imageUrl;

    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public ProductEditDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductEditDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductEditDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ProductEditDto setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductEditDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
