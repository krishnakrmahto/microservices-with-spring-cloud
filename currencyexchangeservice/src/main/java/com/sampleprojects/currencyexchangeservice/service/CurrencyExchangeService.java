package com.sampleprojects.currencyexchangeservice.service;

import com.sampleprojects.currencyexchangeservice.controller.CurrencyExchangeDto;
import com.sampleprojects.currencyexchangeservice.repository.CurrencyExchangeRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyExchangeService {

  private final CurrencyExchangeRepository repository;

  public Optional<CurrencyExchangeDto> getFromToCurrencyExchange(String from, String to) {
    return repository.findFirstByFromCurrencyAndToCurrency(from.toUpperCase(), to.toUpperCase());
  }
}
