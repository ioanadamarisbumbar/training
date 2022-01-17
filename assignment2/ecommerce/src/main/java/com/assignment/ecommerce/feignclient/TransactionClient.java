package com.assignment.ecommerce.feignclient;

import com.assignment.ecommerce.dto.TransactionRequest;
import com.assignment.ecommerce.dto.TransactionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

//@FeignClient(value = "fundtransfer-service", url = "http://localhost:8082/fundtransfer/transaction")
@FeignClient(name = "http://FUNDTRANSFER-SERVICE/fundtransfer/transaction")
public interface TransactionClient {

    @PostMapping("/transferFunds")
    TransactionResponse transferFunds(TransactionRequest transactionRequest);
}
