package com.assignment.ecommerce.service;

import com.assignment.ecommerce.dto.BoughtProductDto;
import com.assignment.ecommerce.entity.BoughtProduct;
import com.assignment.ecommerce.exception.EcommerceException;

import java.util.List;

public interface BoughtProductService {

    BoughtProductDto buyProduct(BoughtProductDto boughtProductDto) throws EcommerceException;
    List<BoughtProductDto> getHistory();
}
