package com.gft.ms_relationship_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.gft.ms_relationship_service.client")
public class MsRelationshipServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsRelationshipServiceApplication.class, args);
	}

}
