package com.assignment.ecommerce.service.impl;

import com.assignment.ecommerce.dto.ProductDto;
import com.assignment.ecommerce.entity.Product;
import com.assignment.ecommerce.mapper.DbEntityMapper;
import com.assignment.ecommerce.repository.ProductRepository;
import com.assignment.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    DbEntityMapper dbEntityMapper;

    @Override
    public Product updateProductQuantity(Long productId, Long quantity) {
        Product dbProduct = getProductById(productId);
        Long newQuantity = dbProduct.getQuantity() - quantity;
        dbProduct.setQuantity(newQuantity);
        return productRepository.save(dbProduct);
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            return product.get();
        }
        return null;
    }

    @Override
    public List<ProductDto> getProductsByKeyword(String keyword) {
        return productRepository.findByKeyword(keyword).stream().map(dbEntityMapper::mapModelToDto).collect(Collectors.toList());
    }
}
