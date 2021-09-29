package com.exchangerate.commons.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.exchangerate.commons.utils.Constants;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = Constants.GENERIC_ERROR_MESSAGE)
public class ExchangeRateException extends RuntimeException {

	private static final long serialVersionUID = 2043739514434909077L;

	public ExchangeRateException() {
		super();
	}

	public ExchangeRateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExchangeRateException(String message, Throwable cause) {
		super(message, cause);
	}

	public ExchangeRateException(String message) {
		super(message);
	}

	public ExchangeRateException(Throwable cause) {
		super(cause);
	}
}
