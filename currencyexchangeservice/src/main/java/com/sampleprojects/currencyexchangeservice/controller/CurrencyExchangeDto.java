package com.sampleprojects.currencyexchangeservice.controller;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CurrencyExchangeDto {

  Long id;
  String from;
  String to;
  BigDecimal conversionMultiple;

}
