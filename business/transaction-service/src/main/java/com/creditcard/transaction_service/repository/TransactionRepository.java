package com.creditcard.transaction_service.repository;

import com.creditcard.transaction_service.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

    List<Transaction> findByCardIdAndTransactionDateBetween(
            String cardId,
            LocalDate from,
            LocalDate to
    );
}