package com.sampleprojects.currencyconversionservice.api.client.rest;

import com.sampleprojects.currencyconversionservice.api.client.response.CurrencyExchangeResponse;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class CurrencyExchangeClientLegacy {

  private final RestTemplate restTemplate;

  public CurrencyExchangeResponse getCurrencyExchange(String from, String to) {

    URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8000/currency-exchange")
        .queryParam("from", from)
        .queryParam("to", to)
        .build()
        .toUri();

    return restTemplate.getForObject(uri, CurrencyExchangeResponse.class);
  }

}
