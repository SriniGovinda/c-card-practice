package com.creditcard.transaction_service.audit;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionViewAuditRepository
        extends JpaRepository<TransactionViewAudit, String> {
}