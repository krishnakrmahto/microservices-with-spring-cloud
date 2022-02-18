package com.sampleprojects.currencyconversionservice.api.client.response;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@Value
public class CurrencyExchangeResponse {

  String fromCurrency;
  String toCurrency;
  BigDecimal conversionMultiple;

}
