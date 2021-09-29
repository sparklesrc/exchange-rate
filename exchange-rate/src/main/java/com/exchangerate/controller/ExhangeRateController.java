package com.exchangerate.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.exchangerate.commons.dto.ExchangeRateUpdateRequest;
import com.exchangerate.commons.dto.ExchangeRequest;
import com.exchangerate.commons.dto.ExchangeResponse;
import com.exchangerate.commons.exceptions.ExchangeRateException;
import com.exchangerate.model.entity.ExchangeRate;
import com.exchangerate.service.ExchangeRateService;
import io.reactivex.Observable;
import io.reactivex.Single;

@RestController
@RequestMapping(value = "/exchange-rates")
public class ExhangeRateController {

	@Autowired
	private ExchangeRateService service;

	@RequestMapping(method = RequestMethod.GET)
	public Observable<List<ExchangeRate>> list() throws ExchangeRateException, Exception {
		return service.getExchangeRates();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Single<ExchangeRate> get(@PathVariable Long id) throws ExchangeRateException, Exception {
		return Single.fromObservable(service.findById(id));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Single<ExchangeRate> update(@RequestBody ExchangeRateUpdateRequest request, @PathVariable Long id)
			throws ExchangeRateException, Exception {
		return Single.fromObservable(service.update(request, id));
	}

	@RequestMapping(value = "/convert", method = RequestMethod.POST)
	public Single<ExchangeResponse> convert(@RequestBody ExchangeRequest request)
			throws ExchangeRateException, Exception {
		return Single.fromObservable(service.convert(request));
	}
}
