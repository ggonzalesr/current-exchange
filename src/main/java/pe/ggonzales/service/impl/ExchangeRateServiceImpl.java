package pe.ggonzales.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.ggonzales.dto.ExchangeRateRequest;
import pe.ggonzales.dto.ExchangeRateResponse;
import pe.ggonzales.dto.ExchangeRateUpdateRequest;
import pe.ggonzales.exception.NotFoundException;
import pe.ggonzales.model.ExchangeRate;
import pe.ggonzales.repository.ExchangeRateRepository;
import pe.ggonzales.service.IExchangeRateService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ExchangeRateServiceImpl implements IExchangeRateService {

    private final ExchangeRateRepository exchangeRateRepository;
    private final AuditService auditService;
    
    @Override
    public Mono<ExchangeRateResponse> convertAmount(ExchangeRateRequest request, String username) {
        return exchangeRateRepository.findByFromCurrencyAndToCurrency(request.fromCurrency(), request.toCurrency())
                .switchIfEmpty(Mono.error(new NotFoundException("Tipo de cambio no encontrado")))
                .flatMap(rate -> {
                    BigDecimal convertedAmount = request.amount().multiply(rate.getRate());
                    ExchangeRateResponse response = new ExchangeRateResponse(
                            request.amount(), 
                            request.fromCurrency(), 
                            request.toCurrency(), 
                            rate.getRate(), 
                            convertedAmount
                    );
                    
                    return auditService.logConversion(
                            username, 
                            request.fromCurrency(), 
                            request.toCurrency(), 
                            request.amount(), 
                            convertedAmount, 
                            rate.getRate()
                    ).thenReturn(response);
                });
    }
    
    @Override
    public Mono<ExchangeRate> updateExchangeRate(ExchangeRateUpdateRequest request) {
        return exchangeRateRepository.findByFromCurrencyAndToCurrency(request.fromCurrency(), request.toCurrency())
                .switchIfEmpty(Mono.error(new NotFoundException("Tipo de cambio no encontrado")))
                .flatMap(rate -> {
                    rate.setRate(request.newRate());
                    return exchangeRateRepository.save(rate);
                });
    }
    
    @Override
    public Flux<ExchangeRate> getAllRates() {
        return exchangeRateRepository.findAll();
    }
    
    @Override
    public Mono<ExchangeRate> createRate(ExchangeRate rate) {
        return exchangeRateRepository.save(rate);
    }
}

