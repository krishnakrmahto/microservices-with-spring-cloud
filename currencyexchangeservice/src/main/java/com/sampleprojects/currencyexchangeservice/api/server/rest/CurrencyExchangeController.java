package com.sampleprojects.currencyexchangeservice.api.server.rest;

import com.sampleprojects.currencyexchangeservice.api.server.exception.CurrencyExchangeNotFoundException;
import com.sampleprojects.currencyexchangeservice.api.server.response.CurrencyExchangeResponse;
import com.sampleprojects.currencyexchangeservice.service.CurrencyExchangeService;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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
  @RateLimiter(name = "currency-exchange-get", fallbackMethod = "rateLimiterFallback")
  @Bulkhead(name = "currency-exchange-get", fallbackMethod = "bulkHeadFallback")
  public CurrencyExchangeResponse getFromToCurrencyExchange(@RequestParam String from, @RequestParam String to) {

    System.out.println("LocalDateTime.now() " + LocalDateTime.now());
    return service.getFromToCurrencyExchange(from, to)
        .orElseThrow(() -> new CurrencyExchangeNotFoundException(
            String.format("Currency exchange for from: %s, to: %s was not found", from, to)));
  }

  private CurrencyExchangeResponse rateLimiterFallback(String from, String to, Exception e) {
    System.out.println("RateLimiter fallback...");
//    throw new CurrencyExchangeServerException("The currency exchange server seems to be temporarily unable to process new requests");
    return CurrencyExchangeResponse.builder()
        .conversionMultiple(BigDecimal.TEN)
        .toCurrency("rateLimiterFallback..")
        .build();
  }

  private CurrencyExchangeResponse bulkHeadFallback(String from, String to, Exception e) {
    System.out.println("BulkHead fallback...");
//    throw new CurrencyExchangeServerException("The currency exchange server seems to be temporarily unable to process new requests");
    return CurrencyExchangeResponse.builder()
        .conversionMultiple(BigDecimal.TEN)
        .toCurrency("bulkHeadFallback..")
        .build();
  }
}
