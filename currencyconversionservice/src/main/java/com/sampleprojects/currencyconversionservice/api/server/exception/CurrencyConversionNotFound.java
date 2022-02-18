package com.sampleprojects.currencyconversionservice.api.server.exception;

public class CurrencyConversionNotFound extends RuntimeException{

  public CurrencyConversionNotFound(String message) {
    super(message);
  }
}
