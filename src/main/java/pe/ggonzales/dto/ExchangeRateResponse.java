package pe.ggonzales.dto;

import java.math.BigDecimal;

public record ExchangeRateResponse(
		BigDecimal originalAmount,
	    String fromCurrency,
	    String toCurrency,
	    BigDecimal rate,
	    BigDecimal convertedAmount
		) {

}
