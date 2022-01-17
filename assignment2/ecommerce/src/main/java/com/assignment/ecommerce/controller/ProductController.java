package com.assignment.ecommerce.controller;

import com.assignment.ecommerce.dto.ProductDto;
import com.assignment.ecommerce.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@Tag(name = "Product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/searchProducts")
    public List<ProductDto> getProducts(@RequestParam String keyword) {
        return productService.getProductsByKeyword(keyword);
    }
}
