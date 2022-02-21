package com.sampleprojects.currencyconversionservice.api.client.exception;

public class CurrencyExchangeServerException extends RuntimeException {

  public CurrencyExchangeServerException(String message) {
    super(message);
  }
}
