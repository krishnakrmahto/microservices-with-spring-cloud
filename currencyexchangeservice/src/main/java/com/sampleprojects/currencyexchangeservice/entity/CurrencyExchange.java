package com.sampleprojects.currencyexchangeservice.entity;


import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class CurrencyExchange {

  @Id
  @GeneratedValue
  private Long id;

  private String fromCurrency;
  private String toCurrency;
  private BigDecimal conversionMultiple;

}
