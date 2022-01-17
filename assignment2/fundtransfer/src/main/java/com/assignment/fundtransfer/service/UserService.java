package com.assignment.fundtransfer.service;

import com.assignment.fundtransfer.dto.UserDto;
import com.assignment.fundtransfer.exception.BankException;

public interface UserService {

    UserDto createUser(UserDto userDto) throws BankException;
}
