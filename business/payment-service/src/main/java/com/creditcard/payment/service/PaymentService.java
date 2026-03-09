package com.creditcard.payment.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creditcard.payment.domain.Payment;
import com.creditcard.payment.dto.CreatePaymentRequest;
import com.creditcard.payment.repository.PaymentRepository;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Transactional
    public Payment createPayment(CreatePaymentRequest request) {

        String paymentId = UUID.randomUUID().toString();

        Payment payment = new Payment(
                paymentId,
                request.cardId(),
                request.merchantId(),
                request.amount(),
                request.currency(),
                "CREATED",
                LocalDateTime.now()
        );

        return paymentRepository.save(payment);
    }
}