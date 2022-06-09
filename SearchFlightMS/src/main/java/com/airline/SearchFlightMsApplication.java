package com.airline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SearchFlightMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchFlightMsApplication.class, args);
	}

}
