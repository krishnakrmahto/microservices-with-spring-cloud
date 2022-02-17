package com.sampleprojects.currencyexchangeservice.controller.exception;

public class CurrencyExchangeNotFoundException extends RuntimeException {

  public CurrencyExchangeNotFoundException(String message) {
    super(message);
  }
}
