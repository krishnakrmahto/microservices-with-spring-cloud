package com.sampleprojects.microservices.limitsservice.controller.dto;

import lombok.Value;

@Value
public class LimitsDto {

  int minimum;
  int maximum;
}
