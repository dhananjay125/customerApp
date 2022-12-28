package com.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ManageCustomersApplication {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ManageCustomersApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ManageCustomersApplication.class, args);
	}

}
