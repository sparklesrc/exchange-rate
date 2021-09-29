package com.exchangerate.service;

import java.util.List;
import com.exchangerate.commons.dto.ExchangeRateUpdateRequest;
import com.exchangerate.commons.dto.ExchangeRequest;
import com.exchangerate.commons.dto.ExchangeResponse;
import com.exchangerate.model.entity.ExchangeRate;
import io.reactivex.Observable;

public interface ExchangeRateService {

	Observable<ExchangeResponse> convert(ExchangeRequest request) throws Exception;

	Observable<List<ExchangeRate>> getExchangeRates() throws Exception;

	Observable<ExchangeRate> findById(Long id) throws Exception;

	Observable<ExchangeRate> update(ExchangeRateUpdateRequest request, Long id) throws Exception;
}
