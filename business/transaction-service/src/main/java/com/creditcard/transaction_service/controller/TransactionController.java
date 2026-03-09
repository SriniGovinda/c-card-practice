package com.creditcard.transaction_service.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.creditcard.transaction_service.dto.TransactionDetailResponse;
import com.creditcard.transaction_service.dto.TransactionResponse;
import com.creditcard.transaction_service.service.TransactionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService service;

    @GetMapping
    public List<TransactionResponse> getTransactions(
            @RequestParam String cardId,
            @RequestParam LocalDate from,
            @RequestParam LocalDate to
    ) {

        return service.getTransactions(cardId, from, to);

    }

    @GetMapping("/{id}")
    public TransactionDetailResponse getTransaction(@PathVariable String id) {

        return service.getTransaction(id);

    }
}