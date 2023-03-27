package com.myproject.bioshop.model.dto;

import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@NoArgsConstructor
public class ProductViewDto {

    private String name;

    private String category;

    private String description;

    private String imageUrl;

    private BigDecimal price;

    public String getName() {
        return name;
    }

    public ProductViewDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ProductViewDto setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductViewDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ProductViewDto setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductViewDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
