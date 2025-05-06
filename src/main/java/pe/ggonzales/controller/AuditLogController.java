package pe.ggonzales.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.ggonzales.model.AuditLog;
import pe.ggonzales.repository.AuditLogRepository;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/audit-logs")
public class AuditLogController {
    
    private final AuditLogRepository repository;

    public AuditLogController(AuditLogRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Flux<AuditLog> getAllLogs() {
        return repository.findAll();
    }
}