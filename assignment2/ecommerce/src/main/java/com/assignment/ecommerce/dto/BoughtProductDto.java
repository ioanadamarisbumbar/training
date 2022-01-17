package com.assignment.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BoughtProductDto {

    private Long id;

    @NotNull(message = "Product ID cannot be null or empty!")
    private Long productId;

    @NotNull(message = "Account number cannot be null or empty!")
    private Long userAccountNo;

    @NotNull(message = "Quantity cannot be null or empty!")
    private Long quantity;
    private LocalDate boughtAt;
    private Double totalPrice;
}
