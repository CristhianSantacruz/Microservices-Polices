package com.microservice.departmentsSouth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceDepartmentsSouthApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceDepartmentsSouthApplication.class, args);
	}

}
