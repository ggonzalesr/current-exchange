package pe.ggonzales.service;

import pe.ggonzales.dto.ExchangeRateRequest;
import pe.ggonzales.dto.ExchangeRateResponse;
import pe.ggonzales.dto.ExchangeRateUpdateRequest;
import pe.ggonzales.model.ExchangeRate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IExchangeRateService {

	Mono<ExchangeRateResponse> convertAmount(ExchangeRateRequest request, String username);
    Mono<ExchangeRate> updateExchangeRate(ExchangeRateUpdateRequest request);
    Flux<ExchangeRate> getAllRates();
    Mono<ExchangeRate> createRate(ExchangeRate rate);
}
