package com.creditcard.transaction_service.audit;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "transaction_view_audit")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionViewAudit {

    @Id
    private String auditId;

    private String memberId;

    private String transactionId;

    private String viewType;

    private String traceId;

    private String clientIp;

    private String userAgent;

    private Instant viewedAt;
}