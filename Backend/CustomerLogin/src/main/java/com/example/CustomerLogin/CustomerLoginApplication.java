package com.example.CustomerLogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.example.CorsConfig;

@SpringBootApplication
@Import(CorsConfig.class)
public class CustomerLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerLoginApplication.class, args);
	}

}
