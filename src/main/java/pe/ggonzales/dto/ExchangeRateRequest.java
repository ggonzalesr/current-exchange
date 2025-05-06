package pe.ggonzales.dto;

import java.math.BigDecimal;

public record ExchangeRateRequest(
		BigDecimal amount,
	    String fromCurrency,
	    String toCurrency) {

}
