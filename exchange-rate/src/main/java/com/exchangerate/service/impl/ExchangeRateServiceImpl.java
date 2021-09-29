package com.exchangerate.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exchangerate.commons.dto.ExchangeRateUpdateRequest;
import com.exchangerate.commons.dto.ExchangeRequest;
import com.exchangerate.commons.dto.ExchangeResponse;
import com.exchangerate.model.entity.ExchangeRate;
import com.exchangerate.repository.ExchangeRateRepository;
import com.exchangerate.service.ExchangeRateService;
import io.reactivex.Observable;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

	private final static Logger LOG = LoggerFactory.getLogger(ExchangeRateServiceImpl.class);

	@Autowired
	private ExchangeRateRepository exchangeRepository;

	@Override
	public Observable<ExchangeResponse> convert(ExchangeRequest request) throws Exception {
		LOG.info("Apply Currency Convertion ");
		ExchangeRate exchangeRate = exchangeRepository.findRateByOriginDestination(request.getOriginCurrency(),
				request.getDestinationCurrency());

		return Observable.just(new ExchangeResponse(request.getAmount(),
				new BigDecimal(request.getAmount() * exchangeRate.getRate()).setScale(2, RoundingMode.HALF_UP)
						.doubleValue(),
				request.getOriginCurrency(), request.getDestinationCurrency(), exchangeRate.getRate()));
	}

	@Override
	public Observable<ExchangeRate> findById(Long id) throws Exception {
		LOG.info("Find record :: id {} ", id);
		return Observable.just(exchangeRepository.findById(id).orElse(null));
	}

	@Override
	public Observable<ExchangeRate> update(ExchangeRateUpdateRequest request, Long id) throws Exception {
		LOG.info("Update record :: id {} ", id);
		return Observable.just(exchangeRepository.findById(id).map(exchangeRate -> {
			exchangeRate.setRate(request.getRate());
			exchangeRate.setTradingDate(new Date());
			return exchangeRepository.save(exchangeRate);
		}).orElse(null));
	}

	@Override
	public Observable<List<ExchangeRate>> getExchangeRates() throws Exception {
		LOG.info("List all records ");
		return Observable.just(
				StreamSupport.stream(exchangeRepository.findAll().spliterator(), false).collect(Collectors.toList()));
	}

}
