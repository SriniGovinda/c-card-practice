package com.creditcard.transaction_service.service;


import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.creditcard.transaction_service.dto.TransactionDetailResponse;
import com.creditcard.transaction_service.dto.TransactionResponse;
import com.creditcard.transaction_service.mapper.TransactionMapper;
import com.creditcard.transaction_service.repository.TransactionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository repository;

    public List<TransactionResponse> getTransactions(String cardId, LocalDate from, LocalDate to) {

        return repository
                .findByCardIdAndTransactionDateBetween(cardId, from, to)
                .stream()
                .map(TransactionMapper::toResponse)
                .toList();
    }

    public TransactionDetailResponse getTransaction(String id) {

        var tx = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        return TransactionMapper.toDetailResponse(tx);
    }
}