package com.assignment.fundtransfer.controller;

import com.assignment.fundtransfer.dto.TransactionDto;
import com.assignment.fundtransfer.service.TransactionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/transaction")
@Tag(name = "Transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transferFunds")
    public TransactionDto transferFunds(@Valid @RequestBody TransactionDto transactionDto) {
        return transactionService.transferFunds(transactionDto);
    }

    @GetMapping("/statement")
    public List<TransactionDto> getAllStatements(@RequestParam Long accountNumber, @RequestParam int month, @RequestParam int year) {
        return transactionService.getAllStatements(accountNumber, month, year);
    }
}
