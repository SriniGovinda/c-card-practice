package com.creditcard.transaction_service.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Instant;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    private String transactionId;

    private String cardId;

    private LocalDate transactionDate;

    private String merchantName;

    private BigDecimal amount;

    private String currency;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    private String originalTransactionId;

    private String description;

    private Instant createdAt;

    private Instant updatedAt;
}