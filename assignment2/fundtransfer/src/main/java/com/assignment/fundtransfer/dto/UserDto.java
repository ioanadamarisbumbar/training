package com.assignment.fundtransfer.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private Long uid;

    @NotEmpty(message = "First name cannot be null or empty!")
    private String firstName;

    @NotEmpty(message = "Last name cannot be null or empty!")
    private String lastName;

    @NotEmpty(message = "Email cannot be null or empty!")
    @Email(message = "Email should be valid!")
    private String email;

    @NotEmpty(message = "Phone number cannot be null or empty!")
    private String phoneNumber;

    @NotNull(message = "Birth date cannot be null!")
    @Past(message = "Birth date should be in the past!")
    private LocalDate birthDate;
}
