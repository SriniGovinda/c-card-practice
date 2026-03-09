package com.creditcard.payment.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    private String paymentId;

    private String cardId;

    private String merchantId;

    private BigDecimal amount;

    private String currency;

    private String status;

    private LocalDateTime createdAt;

    protected Payment() {}

    public Payment(String paymentId,
                   String cardId,
                   String merchantId,
                   BigDecimal amount,
                   String currency,
                   String status,
                   LocalDateTime createdAt) {

        this.paymentId = paymentId;
        this.cardId = cardId;
        this.merchantId = merchantId;
        this.amount = amount;
        this.currency = currency;
        this.status = status;
        this.createdAt = createdAt;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getCardId() {
        return cardId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}