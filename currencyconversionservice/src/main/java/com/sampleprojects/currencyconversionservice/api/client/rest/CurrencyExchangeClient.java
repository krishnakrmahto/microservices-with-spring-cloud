package com.sampleprojects.currencyconversionservice.api.client.rest;

import com.sampleprojects.currencyconversionservice.api.client.response.CurrencyExchangeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "currency-exchange", url = "localhost:8000/currency-exchange")
public interface CurrencyExchangeClient {

  @GetMapping
  CurrencyExchangeResponse getCurrencyExchange(@RequestParam String from, @RequestParam String to);

}
