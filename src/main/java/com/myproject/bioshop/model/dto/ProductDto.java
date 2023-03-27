package com.myproject.bioshop.model.dto;

import com.myproject.bioshop.model.entity.Category;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

public class ProductDto {

    private String name;

    private String category;

    private String description;

    private String imageUrl;

    private BigDecimal price;

    private boolean isDeleted;

    public ProductDto() {
    }

    public String getName() {
        return name;
    }

    public ProductDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ProductDto setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ProductDto setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public ProductDto setDeleted(boolean deleted) {
        isDeleted = deleted;
        return this;
    }
}
