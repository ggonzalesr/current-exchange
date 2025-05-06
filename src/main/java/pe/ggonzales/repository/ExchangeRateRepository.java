package pe.ggonzales.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import pe.ggonzales.model.ExchangeRate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ExchangeRateRepository extends ReactiveCrudRepository<ExchangeRate, Long> {
    
    @Query("SELECT * FROM exchange_rates WHERE from_currency = :from AND to_currency = :to")
    Mono<ExchangeRate> findByFromCurrencyAndToCurrency(
            @Param("from") String fromCurrency, 
            @Param("to") String toCurrency);
    
    Flux<ExchangeRate> findByFromCurrency(String fromCurrency);
}
