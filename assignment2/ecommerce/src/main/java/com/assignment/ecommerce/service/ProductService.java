package com.assignment.ecommerce.service;

import com.assignment.ecommerce.dto.ProductDto;
import com.assignment.ecommerce.entity.Product;

import java.util.List;

public interface ProductService {

    Product updateProductQuantity(Long productId, Long quantity);
    Product getProductById(Long id);
    List<ProductDto> getProductsByKeyword(String keyword);
}
