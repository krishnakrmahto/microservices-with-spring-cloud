package com.sampleprojects.microservices.limitsservice.controller.rest;

import com.sampleprojects.microservices.limitsservice.controller.dto.LimitsDto;
import com.sampleprojects.microservices.limitsservice.service.LimitsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/limits")
@AllArgsConstructor
public class LimitsController {

  private final LimitsService service;

  @GetMapping
  public LimitsDto getLimits() {
    return service.getLimits();
  }
}
