package com.sampleprojects.currencyexchangeservice.service;

import com.sampleprojects.currencyexchangeservice.api.server.response.CurrencyExchangeResponse;
import com.sampleprojects.currencyexchangeservice.repository.CurrencyExchangeRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyExchangeService {

  private final CurrencyExchangeRepository repository;

  public Optional<CurrencyExchangeResponse> getFromToCurrencyExchange(String from, String to) {
    return repository.findFirstByFromCurrencyAndToCurrency(from.toUpperCase(), to.toUpperCase());
  }
}
