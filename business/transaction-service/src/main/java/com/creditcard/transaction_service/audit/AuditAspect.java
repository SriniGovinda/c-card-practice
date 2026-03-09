package com.creditcard.transaction_service.audit;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class AuditAspect {

    private final AuditService auditService;
    private final HttpServletRequest request;

    @AfterReturning(
            value = "execution(* com.vpass.transaction.controller.TransactionController.getTransaction(..)) && args(id)",
            argNames = "id"
    )
    public void auditTransactionDetail(String id) {

        String memberId = request.getHeader("X-MEMBER-ID");
        String traceId = request.getHeader("X-TRACE-ID");

        String ip = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");

        auditService.saveDetailView(memberId, id, traceId, ip, userAgent);
    }
}