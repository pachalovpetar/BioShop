package com.myproject.bioshop.model.dto;

import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@NoArgsConstructor
public class ProductDetailsDto {

    private String id;

    private String name;

    private String description;

    private String imageUrl;

    private BigDecimal price;


    public String getId() {
        return id;
    }

    public ProductDetailsDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductDetailsDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductDetailsDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ProductDetailsDto setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductDetailsDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
