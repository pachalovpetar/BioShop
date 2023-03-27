package com.myproject.bioshop.web;

import com.myproject.bioshop.model.dto.ProductCreationDto;
import com.myproject.bioshop.model.dto.ProductDetailsDto;
import com.myproject.bioshop.model.dto.ProductEditDto;
import com.myproject.bioshop.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public String getAllProducts() {
        return "products";
    }

    @GetMapping("/add")
    public String getAddProduct(Model model) {

        model.addAttribute("productCreationDto", productCreationDto());

        return "add-product";
    }

    @PostMapping("/add")
    public String postAddProduct(@Valid @ModelAttribute ProductCreationDto productCreationDto,
                                 BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if(productCreationDto == null || bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("productCreationDto", productCreationDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.productCreationDto", bindingResult);

            return "add-product";
        }

        this.productService.addProduct(productCreationDto);

        return "/products";

    }

    @GetMapping("/edit/{id}")
    public String getEditProduct(@PathVariable Long id, Model model) {
        model.addAttribute("productEditDto", productEditDto());

         return "edit-product";
    }
    @GetMapping("/details/{id}")
    public String getProductDetails(@PathVariable Long id, Model model) {
        ProductDetailsDto productDetails = this.productService.getProductDetails(id);

        model.addAttribute("productDetails", productDetails);

        return "details-product";
    }

    @ModelAttribute(name = "productCreationDto")
    public ProductCreationDto productCreationDto() {
        return new ProductCreationDto();
    }

    @ModelAttribute(name = "productEditDto")
    public ProductEditDto productEditDto() {
        return new ProductEditDto();
    }
}
