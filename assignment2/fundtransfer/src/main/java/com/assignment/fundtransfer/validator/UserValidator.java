package com.assignment.fundtransfer.validator;

import com.assignment.fundtransfer.dto.UserDto;
import com.assignment.fundtransfer.exception.BankException;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class UserValidator implements Validator {

    @Override
    public void validate(Object object) throws BankException {
        UserDto userDto = (UserDto) object;

        if (userDto == null){
            throw new BankException("User cannot be null!");
        }
        if(userDto.getUid() == null){
            throw new BankException("Unique identifier cannot be null!");
        }
        if(StringUtils.isEmpty(userDto.getFirstName())){
            throw new BankException("First name cannot be null!");
        }
        if(StringUtils.isEmpty(userDto.getLastName())){
            throw new BankException("Last name cannot be null!");
        }
        if(StringUtils.isEmpty(userDto.getEmail())){
            throw new BankException("Email cannot be null!");
        }
        if(StringUtils.isEmpty(userDto.getPhoneNumber())){
            throw new BankException("Phone number cannot be null!");
        }
        if(ObjectUtils.isEmpty(userDto.getBirthDate())){
            throw new BankException("Birth date cannot be null!");
        }
    }
}
