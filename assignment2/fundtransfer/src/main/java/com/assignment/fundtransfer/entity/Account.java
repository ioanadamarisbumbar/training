package com.assignment.fundtransfer.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "accounts")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account {

    @Id
    private Long accountNumber;
    private Long balance;
    private LocalDate openingDate;

    @OneToOne
    @JoinColumn(name = "user_uid", referencedColumnName = "uid")
//    @JsonManagedReference
    private User user;
}
