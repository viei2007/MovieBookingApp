package com.example.moviebooking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
	@Bean
	public OpenAPI movieBookingOpenAPI() {
		return new OpenAPI().info(new Info().title("Movie Booking API")
				.description("API for browsing theatres by movie, city, and date").version("1.0"));
	}
}
