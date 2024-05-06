package com.demo.cca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

/**
 * Main application class for the Currency Converter API (CCA).
 */
@SpringBootApplication
@Slf4j
public class CcaApplication {
	/**
	 * Main method to start the Currency Converter API application.
	 *
	 * @param args Command-line arguments.
	 */
	public static void main(String[] args) {
		// run the spring application
		log.info("starting the spring application");
		SpringApplication.run(CcaApplication.class, args);
	}
}
