package com.assignment.fundtransfer.controller;

import com.assignment.fundtransfer.exception.BankException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BankExceptionController {

    @ExceptionHandler(value = BankException.class)
    public ResponseEntity<Object> exception(BankException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
