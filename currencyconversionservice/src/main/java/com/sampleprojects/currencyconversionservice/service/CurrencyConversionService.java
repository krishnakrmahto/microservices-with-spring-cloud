package com.sampleprojects.currencyconversionservice.service;

import com.sampleprojects.currencyconversionservice.controller.dto.CurrencyConversionDto;
import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConversionService {

  public Optional<CurrencyConversionDto> getCurrencyConversion(String from, String to, BigDecimal fromAmount) {
    return Optional.of(CurrencyConversionDto.builder()
            .from(from)
            .to(to)
            .conversionMultiple(BigDecimal.TEN)
            .fromAmount(fromAmount).build());
  }
}
