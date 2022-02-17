package com.sampleprojects.currencyexchangeservice.repository;

import com.sampleprojects.currencyexchangeservice.controller.CurrencyExchangeDto;
import com.sampleprojects.currencyexchangeservice.entity.CurrencyExchange;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

  Optional<CurrencyExchangeDto> findFirstByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);
}
