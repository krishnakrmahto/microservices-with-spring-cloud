package com.sampleprojects.currencyconversionservice.controller.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CurrencyConversionDto {
  String from;
  String to;
  BigDecimal conversionMultiple;
  BigDecimal fromAmount;
  BigDecimal toAmount;
}
