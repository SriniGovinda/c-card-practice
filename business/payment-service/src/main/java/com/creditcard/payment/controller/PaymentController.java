package com.creditcard.payment.controller;

import org.springframework.web.bind.annotation.*;

import com.creditcard.payment.domain.Payment;
import com.creditcard.payment.dto.CreatePaymentRequest;
import com.creditcard.payment.dto.CreatePaymentResponse;
import com.creditcard.payment.mapper.PaymentMapper;
import com.creditcard.payment.service.PaymentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public CreatePaymentResponse createPayment(
            @Valid @RequestBody CreatePaymentRequest request) {

        Payment payment = paymentService.createPayment(request);

        return PaymentMapper.toResponse(payment);
    }
}
