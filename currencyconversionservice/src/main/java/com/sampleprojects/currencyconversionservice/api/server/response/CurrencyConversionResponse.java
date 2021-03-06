package com.sampleprojects.currencyconversionservice.api.server.response;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CurrencyConversionResponse {
  String from;
  String to;
  BigDecimal conversionMultiple;
  BigDecimal fromAmount;
  BigDecimal toAmount;
}
