package pe.ggonzales.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pe.ggonzales.dto.ExchangeRateRequest;
import pe.ggonzales.dto.ExchangeRateResponse;
import pe.ggonzales.dto.ExchangeRateUpdateRequest;
import pe.ggonzales.model.ExchangeRate;
import pe.ggonzales.service.IExchangeRateService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/exchange-rates")
@RequiredArgsConstructor
public class ExchangeRateController {

    private final IExchangeRateService exchangeRateService;
    
    @PostMapping("/convert")
    public Mono<ExchangeRateResponse> convertAmount(@RequestBody ExchangeRateRequest request, 
                                                   @AuthenticationPrincipal String username) {
        return exchangeRateService.convertAmount(request, username);
    }
    
    @GetMapping
    public Flux<ExchangeRate> getAllRates() {
        return exchangeRateService.getAllRates();
    }
    
    @PutMapping
    public Mono<ExchangeRate> updateRate(@RequestBody ExchangeRateUpdateRequest request) {
        return exchangeRateService.updateExchangeRate(request);
    }
    
    @PostMapping
    public Mono<ExchangeRate> createRate(@RequestBody ExchangeRate rate) {
        return exchangeRateService.createRate(rate);
    }
}
