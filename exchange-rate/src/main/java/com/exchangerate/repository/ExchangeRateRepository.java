package com.exchangerate.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.exchangerate.model.entity.ExchangeRate;

public interface ExchangeRateRepository extends PagingAndSortingRepository<ExchangeRate, Long>, JpaSpecificationExecutor<ExchangeRate> {

	@Query("select exchange from ExchangeRate exchange where exchange.originCurrency = :origin and exchange.destinationCurrency = :destination")
	public ExchangeRate findRateByOriginDestination(String origin, String destination);
}
