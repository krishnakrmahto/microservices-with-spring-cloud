package com.sampleprojects.currencyconversionservice.api.client.rest;

import com.sampleprojects.currencyconversionservice.api.client.response.CurrencyExchangeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class CurrencyExchangeClient {

  private final RestTemplate restTemplate;

  public CurrencyExchangeResponse getCurrencyExchange(String from, String to) {

    UriComponentsBuilder.fromHttpUrl("http://localhost:8000/currency-exchange")
        .queryParam("from", from)
        .queryParam("to", to);

    return restTemplate.getForObject("http://localhost:8000/currency-exchange", CurrencyExchangeResponse.class);
  }

}
