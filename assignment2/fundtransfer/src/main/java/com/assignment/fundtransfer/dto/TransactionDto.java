package com.assignment.fundtransfer.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionDto {

    @NotNull(message = "From account cannot be null or empty!")
    private Long fromAccount;

    @NotNull(message = "To account cannot be null or empty!")
    private Long toAccount;

    @NotNull(message = "Amount cannot be null or empty!")
    private Long amount;

    private String comments;
    private LocalDate createdAt;
}
