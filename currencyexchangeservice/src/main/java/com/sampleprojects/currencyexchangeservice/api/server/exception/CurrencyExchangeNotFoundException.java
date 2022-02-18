package com.sampleprojects.currencyexchangeservice.api.server.exception;

public class CurrencyExchangeNotFoundException extends RuntimeException {

  public CurrencyExchangeNotFoundException(String message) {
    super(message);
  }
}
