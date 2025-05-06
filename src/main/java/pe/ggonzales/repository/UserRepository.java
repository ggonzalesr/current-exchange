package pe.ggonzales.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import pe.ggonzales.model.User;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {
    Mono<User> findByUsername(String username);
}
