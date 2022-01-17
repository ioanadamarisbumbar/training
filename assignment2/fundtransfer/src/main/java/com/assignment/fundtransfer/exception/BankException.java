package com.assignment.fundtransfer.exception;

public class BankException extends RuntimeException {

    public BankException(String errorMessage) {
        super(errorMessage);
    }
}
