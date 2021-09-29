package com.exchangerate.commons.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeResponse implements Serializable {

	private static final long serialVersionUID = 1341353885623454609L;

	private Double amount;
	private Double totalAmount;
	private String originCurrency;
	private String destinationCurrency;
	private Double exchangeRate;
}
