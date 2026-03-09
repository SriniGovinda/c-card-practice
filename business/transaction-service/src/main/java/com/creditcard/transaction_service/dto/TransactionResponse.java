package com.creditcard.transaction_service.dto;

import com.creditcard.transaction_service.domain.TransactionStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class TransactionResponse {

    private String transactionId;

    private LocalDate transactionDate;

    private String merchantName;

    private BigDecimal amount;

    private String currency;

    private TransactionStatus status;

}