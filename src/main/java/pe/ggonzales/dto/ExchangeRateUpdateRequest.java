package pe.ggonzales.dto;

import java.math.BigDecimal;

public record ExchangeRateUpdateRequest(
		String fromCurrency,
	    String toCurrency,
	    BigDecimal newRate
		) {

}
