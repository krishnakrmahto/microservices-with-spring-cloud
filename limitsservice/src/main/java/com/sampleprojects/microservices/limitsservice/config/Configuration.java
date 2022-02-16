package com.sampleprojects.microservices.limitsservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("limitsservice")
@Data
public class Configuration {

  private int minimum;
  private int maximum;

}
