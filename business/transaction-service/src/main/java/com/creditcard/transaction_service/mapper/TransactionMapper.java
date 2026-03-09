package com.creditcard.transaction_service.mapper;

import com.creditcard.transaction_service.domain.Transaction;
import com.creditcard.transaction_service.dto.TransactionDetailResponse;
import com.creditcard.transaction_service.dto.TransactionResponse;

public class TransactionMapper {

    public static TransactionResponse toResponse(Transaction tx) {

        return TransactionResponse.builder()
                .transactionId(tx.getTransactionId())
                .transactionDate(tx.getTransactionDate())
                .merchantName(tx.getMerchantName())
                .amount(tx.getAmount())
                .currency(tx.getCurrency())
                .status(tx.getStatus())
                .build();
    }

    public static TransactionDetailResponse toDetailResponse(Transaction tx) {

        return TransactionDetailResponse.builder()
                .transactionId(tx.getTransactionId())
                .transactionDate(tx.getTransactionDate())
                .merchantName(tx.getMerchantName())
                .amount(tx.getAmount())
                .currency(tx.getCurrency())
                .status(tx.getStatus())
                .description(tx.getDescription())
                .build();
    }
}