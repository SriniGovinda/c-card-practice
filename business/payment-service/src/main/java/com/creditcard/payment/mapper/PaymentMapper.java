package com.creditcard.payment.mapper;

import com.creditcard.payment.domain.Payment;
import com.creditcard.payment.dto.CreatePaymentResponse;

public class PaymentMapper {

    public static CreatePaymentResponse toResponse(Payment payment) {

        return new CreatePaymentResponse(
                payment.getPaymentId(),
                payment.getStatus()
        );
    }
}