package com.assignment.ecommerce.controller;

import com.assignment.ecommerce.exception.EcommerceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EcommerceExceptionController {

    @ExceptionHandler(value = EcommerceException.class)
    public ResponseEntity<Object> exception(EcommerceException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
