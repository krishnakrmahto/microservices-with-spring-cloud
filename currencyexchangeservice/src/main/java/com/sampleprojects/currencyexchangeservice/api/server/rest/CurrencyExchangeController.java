package com.sampleprojects.currencyexchangeservice.api.server.rest;

import com.sampleprojects.currencyexchangeservice.api.server.exception.CurrencyExchangeNotFoundException;
import com.sampleprojects.currencyexchangeservice.api.server.response.CurrencyExchangeResponse;
import com.sampleprojects.currencyexchangeservice.service.CurrencyExchangeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
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
  @CircuitBreaker(name = "currency-exchange", fallbackMethod = "circuitBreakerFallbackEndpoint")
  @Retry(name = "currency-exchange", fallbackMethod = "retryFallbackEndpoint")
  public CurrencyExchangeResponse getFromToCurrencyExchange(@RequestParam String from, @RequestParam String to) {

    System.out.println("LocalDateTime.now() " + LocalDateTime.now());
    return service.getFromToCurrencyExchange(from, to)
        .orElseThrow(() -> new CurrencyExchangeNotFoundException(
            String.format("Currency exchange for from: %s, to: %s was not found", from, to)));
  }

  private CurrencyExchangeResponse retryFallbackEndpoint(String from, String to, Exception e) {
    System.out.println("Retry Fallback");
    return CurrencyExchangeResponse.builder()
        .fromCurrency("Dummy Retry currency")
        .toCurrency(to)
        .build();
  }

  private CurrencyExchangeResponse circuitBreakerFallbackEndpoint(String from, String to, Exception e) {
    System.out.println("CircuitBreaker Fallback");
    return CurrencyExchangeResponse.builder()
        .fromCurrency("Dummy CircuitBreaker currency")
        .toCurrency(to)
        .build();
  }
}
