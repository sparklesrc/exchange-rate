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
public class ExchangeRequest implements Serializable {

	private static final long serialVersionUID = 4374428067907892401L;

	private Double amount;
	private String originCurrency;
	private String destinationCurrency;
}
