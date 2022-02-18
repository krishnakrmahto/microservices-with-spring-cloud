package com.sampleprojects.currencyconversionservice.api.client.response;

import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class CurrencyExchangeResponse {

  String fromCurrency;
  String toCurrency;
  BigDecimal conversionMultiple;

}
