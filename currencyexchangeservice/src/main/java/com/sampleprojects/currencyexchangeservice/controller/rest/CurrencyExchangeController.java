package com.sampleprojects.currencyexchangeservice.controller.rest;

import com.sampleprojects.currencyexchangeservice.controller.CurrencyExchangeDto;
import com.sampleprojects.currencyexchangeservice.controller.exception.CurrencyExchangeNotFoundException;
import com.sampleprojects.currencyexchangeservice.service.CurrencyExchangeService;
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
  public CurrencyExchangeDto getFromToCurrencyExchange(@RequestParam String from, @RequestParam String to) {

    return service.getFromToCurrencyExchange(from, to)
        .orElseThrow(() -> new CurrencyExchangeNotFoundException(
            String.format("Currency exchange for from: %s, to: %s was not found", from, to)));
  }
}
