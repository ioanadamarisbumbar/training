package com.assignment.fundtransfer.mapper;

import com.assignment.fundtransfer.dto.TransactionDto;
import com.assignment.fundtransfer.dto.UserDto;
import com.assignment.fundtransfer.entity.Account;
import com.assignment.fundtransfer.entity.Transaction;
import com.assignment.fundtransfer.entity.User;
import com.assignment.fundtransfer.exception.BankException;
import com.assignment.fundtransfer.service.AccountService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DbEntityMapper {

    @Autowired
    private AccountService accountService;

    public UserDto mapModelToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setBirthDate(user.getBirthDate());
        return userDto;
    }

    public User mapDtoToModel(UserDto userDto) {
        User user = new User();
        user.setUid(userDto.getUid());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setBirthDate(userDto.getBirthDate());
        return user;
    }

    public TransactionDto mapModelToDto(Transaction transaction) {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setFromAccount(transaction.getFromAccount().getAccountNumber());
        transactionDto.setToAccount(transaction.getToAccount().getAccountNumber());
        transactionDto.setAmount(transaction.getAmount());
        transactionDto.setComments(transaction.getComments());
        transactionDto.setCreatedAt(transaction.getCreatedAt());
        return transactionDto;
    }

    public Transaction mapDtoToModel(TransactionDto transactionDto) throws BankException {
        Account fromAccount = accountService.getAccountById(transactionDto.getFromAccount());
        Account toAccount = accountService.getAccountById(transactionDto.getToAccount());
        if (ObjectUtils.isEmpty(fromAccount)) {
            throw new BankException("The account from which to transfer does not exist!");
        }
        if (ObjectUtils.isEmpty(toAccount)) {
            throw new BankException("The account to whom to transfer does not exist!");
        }

        Transaction transaction = new Transaction();
        transaction.setFromAccount(fromAccount);
        transaction.setToAccount(toAccount);
        transaction.setAmount(transactionDto.getAmount());
        transaction.setComments(transactionDto.getComments());
        return transaction;
    }
}
