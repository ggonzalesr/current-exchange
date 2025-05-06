package pe.ggonzales.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.ggonzales.model.AuditLog;
import pe.ggonzales.repository.AuditLogRepository;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AuditService {

    private final AuditLogRepository auditLogRepository;
    
    public Mono<AuditLog> logConversion(String username, String fromCurrency, String toCurrency, 
                                       BigDecimal amount, BigDecimal convertedAmount, BigDecimal rate) {
        AuditLog log = new AuditLog();
        log.setUsername(username);
        log.setFromCurrency(fromCurrency);
        log.setToCurrency(toCurrency);
        log.setOriginalAmount(amount);
        log.setConvertedAmount(convertedAmount);
        log.setRate(rate);
        log.setTimestamp(LocalDateTime.now());
        
        return auditLogRepository.save(log);
    }
}
