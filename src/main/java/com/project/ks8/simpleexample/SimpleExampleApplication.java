package com.project.ks8.simpleexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SimpleExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleExampleApplication.class, args);
	}

}
