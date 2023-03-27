package com.myproject.bioshop.web;

import com.myproject.bioshop.model.dto.ProductDto;
import com.myproject.bioshop.model.dto.ProductViewDto;
import com.myproject.bioshop.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProductRestController {

    private final ProductService productService;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductRestController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductViewDto>> showAllProducts() {

        List<ProductViewDto> allProduct = productService
                .getAllProduct()
                .stream()
                .map(p -> this.modelMapper.map(p, ProductViewDto.class))
                .toList();

        return ResponseEntity.ok(allProduct);
    }
}
