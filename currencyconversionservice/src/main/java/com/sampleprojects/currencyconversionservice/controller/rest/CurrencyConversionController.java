package com.sampleprojects.currencyconversionservice.controller.rest;

import com.sampleprojects.currencyconversionservice.controller.dto.CurrencyConversionDto;
import com.sampleprojects.currencyconversionservice.controller.exception.CurrencyConversionNotFound;
import com.sampleprojects.currencyconversionservice.service.CurrencyConversionService;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency-conversion")
@RequiredArgsConstructor
public class CurrencyConversionController {

  private final CurrencyConversionService service;

  @GetMapping
  public CurrencyConversionDto getCurrencyConversion(@RequestParam String from, @RequestParam String to,
      @RequestParam BigDecimal fromAmount) {

    return service.getCurrencyConversion(from, to, fromAmount)
        .orElseThrow(() -> new CurrencyConversionNotFound("Currency conversion not found"));
  }

}
