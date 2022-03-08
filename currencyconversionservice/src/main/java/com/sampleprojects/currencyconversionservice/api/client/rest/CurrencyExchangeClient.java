package com.sampleprojects.currencyconversionservice.api.client.rest;

import com.sampleprojects.currencyconversionservice.api.client.response.CurrencyExchangeResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import java.math.BigDecimal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "currency-exchange-service", url = "${CURRENCY_EXCHANGE_SERVICE_HOST:http://localhost}:${PORT:8000}", path = "/currency-exchange")
public interface CurrencyExchangeClient {

  @GetMapping
  @Retry(name = "currency-exchange-service-get-exchange")
  @CircuitBreaker(name = "currency-exchange-service-get-exchange", fallbackMethod = "circuitBreakerFallback")
  CurrencyExchangeResponse getCurrencyExchange(@RequestParam String from, @RequestParam String to);

  default CurrencyExchangeResponse retryFallback(String from, String to, Exception e) {

    System.out.println("Retry fallback...");
//    throw new CurrencyExchangeServerException("Unable to fetch currency exchange after multiple retries.");
    return CurrencyExchangeResponse.builder()
        .conversionMultiple(BigDecimal.TEN)
        .toCurrency("Retry fallback..")
        .build();
  }

  default CurrencyExchangeResponse circuitBreakerFallback(String from, String to, Exception e) {
    System.out.println("CircuitBreaker fallback...");
//    throw new CurrencyExchangeServerException("The currency exchange server seems to be temporarily unable to process new requests");
    return CurrencyExchangeResponse.builder()
        .conversionMultiple(BigDecimal.TEN)
        .toCurrency("CB fallback..")
        .build();
  }
}
