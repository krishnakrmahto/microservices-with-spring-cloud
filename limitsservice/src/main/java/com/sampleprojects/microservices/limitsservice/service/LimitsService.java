package com.sampleprojects.microservices.limitsservice.service;

import com.sampleprojects.microservices.limitsservice.config.Configuration;
import com.sampleprojects.microservices.limitsservice.controller.dto.LimitsDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LimitsService {

  private final Configuration configuration;

  public LimitsDto getLimits() {
    return new LimitsDto(configuration.getMinimum(), configuration.getMaximum());
  }
}
