package com.demo.cca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the Currency Converter API (CCA).
 */
@SpringBootApplication
public class CcaApplication {

	/**
	 * Main method to start the Currency Converter API application.
	 *
	 * @param args Command-line arguments.
	 */
	public static void main(String[] args) {
		// run the spring application
		SpringApplication.run(CcaApplication.class, args);
	}

}
