package com.creditcard.payment.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreatePaymentRequest(

        @NotBlank
        String cardId,

        @NotBlank
        String merchantId,

        @NotNull
        @DecimalMin("1.00")
        BigDecimal amount,

        @NotBlank
        String currency

) {
}