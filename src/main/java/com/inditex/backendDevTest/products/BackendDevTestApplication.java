package com.inditex.backendDevTest.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class BackendDevTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendDevTestApplication.class, args);
	}

}
