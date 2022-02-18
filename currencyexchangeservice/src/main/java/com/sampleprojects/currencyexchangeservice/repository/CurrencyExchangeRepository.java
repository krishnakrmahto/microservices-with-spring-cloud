package com.sampleprojects.currencyexchangeservice.repository;

import com.sampleprojects.currencyexchangeservice.api.server.response.CurrencyExchangeResponse;
import com.sampleprojects.currencyexchangeservice.entity.CurrencyExchange;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

  Optional<CurrencyExchangeResponse> findFirstByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);
}
