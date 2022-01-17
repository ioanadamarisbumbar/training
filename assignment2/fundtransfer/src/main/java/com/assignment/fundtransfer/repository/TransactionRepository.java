package com.assignment.fundtransfer.repository;

import com.assignment.fundtransfer.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("from Transaction where fromAccount.accountNumber = :accountNumber and createdAt between :startDate and :endDate")
    List<Transaction> getTransactionByCreatedAt(Long accountNumber, LocalDate startDate, LocalDate endDate);

//    List<Transaction> getTransactionByCreatedAtGreaterThanEqualAndCreatedAtLessThanEqual(Date startDate, Date endDate);
//            @Query("from Transaction where fromAccount.accountNumber = :accountNumber and DATE_FORMAT(createdAt, '%m') = :month and DATE_FORMAT(createdAt, '%y') = :year")
}
