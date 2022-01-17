package com.assignment.fundtransfer.service;

import com.assignment.fundtransfer.dto.TransactionDto;
import com.assignment.fundtransfer.exception.BankException;

import java.util.List;

public interface TransactionService {

    TransactionDto transferFunds(TransactionDto transactionDto) throws BankException;
    List<TransactionDto> getAllStatements(Long accountNumber, int month, int year);
}
