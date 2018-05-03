package com.francesyu90.lms.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.francesyu90.lms.service.impl.BookService;

@Configuration
public class TestConfiguration {
	
	@Bean
	public BookService bookService() {
		return new BookService();	
	}
	
}
