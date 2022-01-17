package com.assignment.fundtransfer.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "transactions")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_account_number", referencedColumnName = "accountNumber")
    private Account fromAccount;

    @ManyToOne
    @JoinColumn(name = "to_account_number", referencedColumnName = "accountNumber")
    private Account toAccount;

    private Long amount;
    private String comments;
    private LocalDate createdAt;
}
