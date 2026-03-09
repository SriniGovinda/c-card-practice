package com.creditcard.transaction_service.audit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuditService {

    private final TransactionViewAuditRepository repository;

    public void saveDetailView(String memberId,
                               String transactionId,
                               String traceId,
                               String ip,
                               String userAgent) {

        TransactionViewAudit audit = TransactionViewAudit.builder()
                .auditId(UUID.randomUUID().toString())
                .memberId(memberId)
                .transactionId(transactionId)
                .viewType("DETAIL")
                .traceId(traceId)
                .clientIp(ip)
                .userAgent(userAgent)
                .viewedAt(Instant.now())
                .build();

        repository.save(audit);
    }
}