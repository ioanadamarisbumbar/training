package com.assignment.fundtransfer.service;

import com.assignment.fundtransfer.dto.TransactionDto;
import com.assignment.fundtransfer.entity.Account;
import com.assignment.fundtransfer.entity.Transaction;
import com.assignment.fundtransfer.exception.BankException;
import com.assignment.fundtransfer.mapper.DbEntityMapper;
import com.assignment.fundtransfer.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AccountService accountService;

    @Autowired
    DbEntityMapper dbEntityMapper;

    @Override
    public TransactionDto transferFunds(TransactionDto transactionDto) throws BankException {
        Transaction transaction = dbEntityMapper.mapDtoToModel(transactionDto);
        updateAccountsBalance(transaction);
        transaction.setCreatedAt(LocalDate.now());

        return dbEntityMapper.mapModelToDto(transactionRepository.save(transaction));
    }

    @Override
    public List<TransactionDto> getAllStatements(Long accountNumber, int month, int year) {
        LocalDate startDate = getStartDate(month, year);
        LocalDate endDate = getEndDate(month, year);
        List<Transaction> transactions = transactionRepository.getTransactionByCreatedAt(accountNumber, startDate, endDate);
        return transactions.stream().map(transaction -> dbEntityMapper.mapModelToDto(transaction)).collect(Collectors.toList());

    }

    private void updateAccountsBalance(Transaction transaction) throws BankException {
        Account accountFrom = accountService.getAccountById(transaction.getFromAccount().getAccountNumber());
        if (accountFrom.getBalance() < transaction.getAmount()) {
            throw new BankException("Insufficient funds");
        }
        Long balance = accountFrom.getBalance() - transaction.getAmount();
        accountService.updateAccountBalance(accountFrom, balance);

        Account accountTo = accountService.getAccountById(transaction.getToAccount().getAccountNumber());
        balance = accountTo.getBalance() + transaction.getAmount();
        accountService.updateAccountBalance(accountTo, balance);
    }

    private LocalDate getStartDate(int month, int year) {
        return LocalDate.of(year, month, 1);
    }

    private LocalDate getEndDate(int month, int year) {
        LocalDate date = LocalDate.of(year, month, 1);
        int monthLength = date.lengthOfMonth();
        return LocalDate.of(year, month, monthLength);
    }
}
