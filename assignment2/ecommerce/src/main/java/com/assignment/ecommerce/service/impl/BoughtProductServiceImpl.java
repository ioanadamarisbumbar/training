package com.assignment.ecommerce.service.impl;

import com.assignment.ecommerce.dto.BoughtProductDto;
import com.assignment.ecommerce.dto.TransactionRequest;
import com.assignment.ecommerce.entity.BoughtProduct;
import com.assignment.ecommerce.entity.Product;
import com.assignment.ecommerce.exception.EcommerceException;
import com.assignment.ecommerce.feignclient.TransactionClient;
import com.assignment.ecommerce.mapper.DbEntityMapper;
import com.assignment.ecommerce.repository.BoughtProductRepository;
import com.assignment.ecommerce.service.BoughtProductService;
import com.assignment.ecommerce.service.ProductService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoughtProductServiceImpl implements BoughtProductService {

    @Value("${ecommerce.account.number}")
    private Long ecommerceAccountNo;

    @Autowired
    BoughtProductRepository boughtProductRepository;

    @Autowired
    DbEntityMapper dbEntityMapper;

    @Autowired
    TransactionClient transactionClient;

    @Autowired
    ProductService productService;

    @Override
    public BoughtProductDto buyProduct(BoughtProductDto boughtProductDto) throws EcommerceException {
        BoughtProduct boughtProduct = dbEntityMapper.mapDtoToModel(boughtProductDto);

        Product product = productService.getProductById(boughtProductDto.getProductId());
        if (ObjectUtils.isEmpty(product)) {
            throw new EcommerceException("The product does not exist!");
        }
        if (product.getQuantity() < boughtProductDto.getQuantity()) {
            throw new EcommerceException("The desired quantity does not exist for product " + product.getName() + "!");
        }

        boughtProduct.setProduct(product);
        boughtProduct.setECommerceAccountNo(ecommerceAccountNo);
        Double price = boughtProduct.getProduct().getPrice() * boughtProduct.getQuantity();
        boughtProduct.setTotalPrice(price);
        boughtProduct.setBoughtAt(LocalDate.now());

        try {
            productService.updateProductQuantity(boughtProduct.getProduct().getId(), boughtProduct.getQuantity());
            makeTransfer(boughtProduct);
        } catch (RuntimeException ex) {
            throw new EcommerceException(ex.getMessage());
        }
        return dbEntityMapper.mapModelToDto(boughtProductRepository.save(boughtProduct));
    }

    @Override
    public List<BoughtProductDto> getHistory() {
        List<BoughtProduct> boughtProducts = boughtProductRepository.findAll();
        return boughtProducts.stream().map(dbEntityMapper::mapModelToDto).collect(Collectors.toList());
    }

    private void makeTransfer(BoughtProduct boughtProduct) {
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setFromAccount(boughtProduct.getUserAccountNo());
        transactionRequest.setToAccount(boughtProduct.getECommerceAccountNo());
        transactionRequest.setAmount(boughtProduct.getTotalPrice().longValue());
        transactionRequest.setComments("Bought product: " + boughtProduct.getProduct().getName());
        transactionClient.transferFunds(transactionRequest);

    }
}
