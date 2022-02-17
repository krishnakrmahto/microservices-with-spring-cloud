package com.sampleprojects.currencyconversionservice.controller.exception;

public class CurrencyConversionNotFound extends RuntimeException{

  public CurrencyConversionNotFound(String message) {
    super(message);
  }
}
