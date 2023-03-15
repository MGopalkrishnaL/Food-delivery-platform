package com.Geekster.MCT.Food.delivery.platform;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class FoodDeliveryPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodDeliveryPlatformApplication.class, args);
	}

}
