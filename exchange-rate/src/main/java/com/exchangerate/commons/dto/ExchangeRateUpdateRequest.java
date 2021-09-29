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
public class ExchangeRateUpdateRequest implements Serializable {

	private static final long serialVersionUID = 4347494354642379498L;

	private Double rate;
}
