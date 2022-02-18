package com.sampleprojects.currencyexchangeservice.api.server.response;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@Builder
@RequiredArgsConstructor
public class CurrencyExchangeResponse {

  String fromCurrency;
  String toCurrency;
  BigDecimal conversionMultiple;

}
