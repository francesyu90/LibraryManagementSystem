package com.francesyu90.lms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LmsApplication {
	
	private static final Logger log = LoggerFactory.getLogger(LmsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LmsApplication.class, args);
	}
	
}
