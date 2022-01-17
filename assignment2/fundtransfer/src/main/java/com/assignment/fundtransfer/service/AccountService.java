package com.assignment.fundtransfer.service;

import com.assignment.fundtransfer.entity.Account;
import com.assignment.fundtransfer.entity.User;

public interface AccountService {

    Account createAccount(User user);
    Account updateAccountBalance(Account account, Long balance);
    Account getAccountById(Long id);
}
