package com.demo.cca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.cca.helpers.EnvironmentHelper;

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
		// load dotenv file
		EnvironmentHelper.loadDotEnvFile();

		// run the spring application
		SpringApplication.run(CcaApplication.class, args);
	}
}
