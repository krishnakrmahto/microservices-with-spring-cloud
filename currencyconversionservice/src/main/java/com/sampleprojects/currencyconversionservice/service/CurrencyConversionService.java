package com.sampleprojects.currencyconversionservice.service;

import com.sampleprojects.currencyconversionservice.api.client.response.CurrencyExchangeResponse;
import com.sampleprojects.currencyconversionservice.api.client.rest.CurrencyExchangeClient;
import com.sampleprojects.currencyconversionservice.api.server.response.CurrencyConversionResponse;
import java.math.BigDecimal;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyConversionService {

  private final CurrencyExchangeClient currencyExchangeClient;

  public Optional<CurrencyConversionResponse> getCurrencyConversion(String from, String to, BigDecimal fromAmount) {

    CurrencyExchangeResponse currencyExchange = currencyExchangeClient.getCurrencyExchange(from, to);

    BigDecimal conversionMultiple = currencyExchange.getConversionMultiple();

    return Optional.of(CurrencyConversionResponse.builder()
            .from(currencyExchange.getFromCurrency())
            .to(currencyExchange.getToCurrency())
            .conversionMultiple(conversionMultiple)
            .fromAmount(fromAmount)
            .toAmount(fromAmount.multiply(conversionMultiple))
        .build());
  }
}
