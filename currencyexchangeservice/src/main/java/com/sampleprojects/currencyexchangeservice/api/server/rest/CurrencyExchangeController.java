package com.sampleprojects.currencyexchangeservice.api.server.rest;

import com.sampleprojects.currencyexchangeservice.api.server.exception.CurrencyExchangeNotFoundException;
import com.sampleprojects.currencyexchangeservice.api.server.response.CurrencyExchangeResponse;
import com.sampleprojects.currencyexchangeservice.service.CurrencyExchangeService;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency-exchange")
@RequiredArgsConstructor
@Slf4j
public class CurrencyExchangeController {

  private final CurrencyExchangeService service;
  private final Environment environment;

  @GetMapping
  @RateLimiter(name = "currency-exchange-get", fallbackMethod = "rateLimiterFallback")
  @Bulkhead(name = "currency-exchange-get", fallbackMethod = "bulkHeadFallback")
  public CurrencyExchangeResponse getFromToCurrencyExchange(@RequestParam String from, @RequestParam String to) {

    log.info("Running on hostName: {}" + environment.getProperty("HOSTNAME"));

    return service.getFromToCurrencyExchange(from, to)
        .orElseThrow(() -> new CurrencyExchangeNotFoundException(
            String.format("Currency exchange for from: %s, to: %s was not found", from, to)));
  }

  private CurrencyExchangeResponse rateLimiterFallback(String from, String to, Exception e) {
    System.out.println("RateLimiter fallback...");
    return CurrencyExchangeResponse.builder()
        .conversionMultiple(BigDecimal.TEN)
        .toCurrency("rateLimiterFallback..")
        .build();
  }

  private CurrencyExchangeResponse bulkHeadFallback(String from, String to, Exception e) {
    System.out.println("BulkHead fallback...");
    return CurrencyExchangeResponse.builder()
        .conversionMultiple(BigDecimal.TEN)
        .toCurrency("bulkHeadFallback..")
        .build();
  }
}
