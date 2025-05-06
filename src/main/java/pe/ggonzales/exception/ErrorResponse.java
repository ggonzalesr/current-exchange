package pe.ggonzales.exception;

import java.time.LocalDateTime;

public record ErrorResponse(String message,
	    LocalDateTime timestamp,
	    String path) {

}
