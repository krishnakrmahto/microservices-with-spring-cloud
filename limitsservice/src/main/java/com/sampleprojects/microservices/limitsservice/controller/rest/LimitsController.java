package com.sampleprojects.microservices.limitsservice.controller.rest;

import com.sampleprojects.microservices.limitsservice.controller.dto.LimitsDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/limits")
public class LimitsController {

  @GetMapping
  public LimitsDto getLimits() {
    return new LimitsDto(1, 1000);
  }
}
