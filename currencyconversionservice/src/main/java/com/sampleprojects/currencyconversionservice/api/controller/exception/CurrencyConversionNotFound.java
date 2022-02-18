package com.sampleprojects.currencyconversionservice.api.controller.exception;

public class CurrencyConversionNotFound extends RuntimeException{

  public CurrencyConversionNotFound(String message) {
    super(message);
  }
}
