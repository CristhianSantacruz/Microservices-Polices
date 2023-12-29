package com.microservice.policies.microservicepolicies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicePoliciesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicePoliciesApplication.class, args);
	}

}
