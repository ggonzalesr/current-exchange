package pe.ggonzales.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import pe.ggonzales.model.AuditLog;

public interface AuditLogRepository extends ReactiveCrudRepository<AuditLog, Long> {
}
