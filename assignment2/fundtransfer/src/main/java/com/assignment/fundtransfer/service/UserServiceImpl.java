package com.assignment.fundtransfer.service;

import com.assignment.fundtransfer.dto.UserDto;
import com.assignment.fundtransfer.entity.User;
import com.assignment.fundtransfer.exception.BankException;
import com.assignment.fundtransfer.mapper.DbEntityMapper;
import com.assignment.fundtransfer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AccountService accountService;

    @Autowired
    DbEntityMapper dbEntityMapper;

    @Override
    public UserDto createUser(UserDto userDto) throws BankException {
        User user = dbEntityMapper.mapDtoToModel(userDto);

        User createdUser = userRepository.save(user);
        accountService.createAccount(user);

        return dbEntityMapper.mapModelToDto(createdUser);
    }
}
