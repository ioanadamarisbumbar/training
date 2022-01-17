package com.assignment.ecommerce.mapper;

import com.assignment.ecommerce.dto.BoughtProductDto;
import com.assignment.ecommerce.dto.ProductDto;
import com.assignment.ecommerce.entity.BoughtProduct;
import com.assignment.ecommerce.entity.Product;
import com.assignment.ecommerce.exception.EcommerceException;
import org.springframework.stereotype.Component;

@Component
public class DbEntityMapper {

    public ProductDto mapModelToDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setBrand(product.getBrand());
        productDto.setCategory(product.getCategory());
        productDto.setReleaseYear(product.getReleaseYear());
        productDto.setQuantity(product.getQuantity());
        productDto.setPrice(product.getPrice());
        return productDto;
    }

    public BoughtProductDto mapModelToDto(BoughtProduct boughtProduct) {
        BoughtProductDto boughtProductDto = new BoughtProductDto();
        boughtProductDto.setId(boughtProduct.getId());
        boughtProductDto.setProductId(boughtProduct.getProduct().getId());
        boughtProductDto.setUserAccountNo(boughtProduct.getUserAccountNo());
        boughtProductDto.setQuantity(boughtProduct.getQuantity());
        boughtProductDto.setTotalPrice(boughtProduct.getTotalPrice());
        boughtProductDto.setBoughtAt(boughtProduct.getBoughtAt());
        return boughtProductDto;
    }

    public BoughtProduct mapDtoToModel(BoughtProductDto boughtProductDto) throws EcommerceException {
        BoughtProduct boughtProduct = new BoughtProduct();
        boughtProduct.setId(boughtProductDto.getId());
        boughtProduct.setUserAccountNo(boughtProductDto.getUserAccountNo());
        boughtProduct.setQuantity(boughtProductDto.getQuantity());
        boughtProduct.setBoughtAt(boughtProductDto.getBoughtAt());
        return boughtProduct;
    }
}
