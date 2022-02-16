package com.sampleprojects.microservices.limitsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class LimitsserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LimitsserviceApplication.class, args);
	}

}
