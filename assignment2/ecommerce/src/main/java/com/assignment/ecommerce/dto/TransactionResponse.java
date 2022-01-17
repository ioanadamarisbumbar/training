package com.assignment.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionResponse {

    private Long fromAccount;
    private Long toAccount;
    private Long amount;
    private String comments;
    private LocalDate createdAt;
}
