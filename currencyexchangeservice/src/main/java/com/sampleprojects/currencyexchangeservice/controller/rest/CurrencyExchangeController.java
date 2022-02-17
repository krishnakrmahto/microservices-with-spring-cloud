package com.sampleprojects.currencyexchangeservice.controller.rest;

import com.sampleprojects.currencyexchangeservice.controller.CurrencyExchangeDto;
import com.sampleprojects.currencyexchangeservice.service.CurrencyExchangeService;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency-exchange")
@RequiredArgsConstructor
public class CurrencyExchangeController {

  private final CurrencyExchangeService service;

  @GetMapping
  public CurrencyExchangeDto getFromToCurrencyConversion(@RequestParam String from, @RequestParam String to) {

    return CurrencyExchangeDto.builder()
        .id(110L)
        .from(from)
        .to(to)
        .conversionMultiple(BigDecimal.valueOf(50))
        .build();
  }
}
