package com.assignment.fundtransfer.service;

import com.assignment.fundtransfer.entity.Account;
import com.assignment.fundtransfer.entity.User;
import com.assignment.fundtransfer.repository.AccountRepository;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    private static final Long DEFAULT_BALANCE = 5000L;

    @Override
    public Account createAccount(User user) {
        Account account = new Account();
        account.setUser(user);
        account.setAccountNumber(RandomUtils.nextLong(10000, 100000));
        account.setBalance(DEFAULT_BALANCE);
        account.setOpeningDate(LocalDate.now());
        return accountRepository.save(account);
    }

    @Override
    public Account updateAccountBalance(Account account, Long balance) {
        account.setBalance(balance);
        return accountRepository.save(account);
    }

    @Override
    public Account getAccountById(Long accountNumber) {
        Optional<Account> account = accountRepository.findById(accountNumber);

        if (account.isPresent()) {
            return account.get();
        }
        return null;
    }

}
