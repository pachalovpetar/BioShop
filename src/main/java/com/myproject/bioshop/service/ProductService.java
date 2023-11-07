package com.myproject.bioshop.service;

import com.myproject.bioshop.exceptions.ProductDuplicateException;
import com.myproject.bioshop.model.dto.ProductCreationDto;
import com.myproject.bioshop.model.dto.ProductDetailsDto;
import com.myproject.bioshop.model.dto.ProductDto;
import com.myproject.bioshop.model.dto.ProductEditDto;
import com.myproject.bioshop.model.entity.Category;
import com.myproject.bioshop.model.entity.Product;
import com.myproject.bioshop.model.enums.ProductType;
import com.myproject.bioshop.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;


    @Autowired
    public ProductService(ProductRepository productRepository, CategoryService categoryService, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    public void addProduct(ProductCreationDto productCreationDTO) {

        if(this.productRepository.findByName(productCreationDTO.getName()).isPresent()) {
            throw new ProductDuplicateException("This product already exists!");
        }

        Product mappedProduct = this.modelMapper
                .map(productCreationDTO, Product.class);

        Category categoryByType = this.categoryService.getCategoryByType(ProductType.valueOf(productCreationDTO.getCategory()));

        mappedProduct.setCategory(categoryByType);


        this.productRepository.saveAndFlush(mappedProduct);

    }

/*    public ProductDto getProduct(Long id) {

        Optional<Product> productOptional = this.productRepository
                .findByIdAndDeletedIsFalse(id);

        if (productOptional.isEmpty()) {
            throw new NoSuchElementException();
        }

        return this.modelMapper
                .map(productOptional, ProductDto.class);

    }*/

    public List<ProductDto> getAllProduct() {

        return this.productRepository
                .findAll()
                .stream()
                .map(p -> this.modelMapper.map(p, ProductDto.class))
                .toList();
    }

    public void editProduct(Long id, ProductEditDto productEditDto) {
        Product product = this.productRepository
                .findById(id)
                .orElseThrow(NoSuchElementException::new);

        product
                .setName(productEditDto.getName())
                .setDescription(productEditDto.getDescription())
                .setImageUrl(productEditDto.getImageUrl());

        this.productRepository.saveAndFlush(product);

    }

    public ProductDetailsDto getProductDetails(Long id) {
        Product product = this.productRepository.findById(id).orElseThrow(NoSuchElementException::new);

        return this.modelMapper.map(product, ProductDetailsDto.class);
    }

    public void deleteProduct() {

    }
}
