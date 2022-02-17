package com.sampleprojects.currencyexchangeservice.controller;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@Builder
@RequiredArgsConstructor
public class CurrencyExchangeDto {

  String fromCurrency;
  String toCurrency;
  BigDecimal conversionMultiple;

}
