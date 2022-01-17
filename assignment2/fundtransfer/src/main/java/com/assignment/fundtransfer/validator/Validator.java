package com.assignment.fundtransfer.validator;

import com.assignment.fundtransfer.exception.BankException;

public interface Validator {

    void validate(Object object) throws BankException;
}
