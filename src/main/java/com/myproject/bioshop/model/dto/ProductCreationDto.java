package com.myproject.bioshop.model.dto;

import java.math.BigDecimal;

public class ProductCreationDto {

    private String name;

    private String category;

    private String description;

    private String imageUrl;

    private BigDecimal price;

    private boolean isDeleted;

    public ProductCreationDto() {
    }

    public String getName() {
        return name;
    }

    public ProductCreationDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ProductCreationDto setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductCreationDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ProductCreationDto setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductCreationDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public ProductCreationDto setDeleted(boolean deleted) {
        isDeleted = deleted;
        return this;
    }
}
