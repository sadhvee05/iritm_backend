package com.iritm.iritmservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;



@SpringBootApplication
public class IritmservicesApplication {
	

	/*
	 * protected SpringApplicationBuilder configure(SpringApplicationBuilder
	 * application) { return application.sources(IritmservicesApplication.class); }
	 */

	public static void main(String[] args) {
		SpringApplication.run(IritmservicesApplication.class, args);
	}

}
