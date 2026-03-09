package com.creditcard.payment.dto;

public record CreatePaymentResponse(
        String paymentId,
        String status
) {
}
