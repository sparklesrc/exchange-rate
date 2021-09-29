package com.exchangerate.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ExchangeRate implements Serializable {

	private static final long serialVersionUID = 7672575330598356144L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 5)
	private String originCurrency;

	@Column(nullable = false, length = 5)
	private String destinationCurrency;

	@Column(nullable = false)
	private Double rate;

	@Column(nullable = false)
	private Date tradingDate;
}
