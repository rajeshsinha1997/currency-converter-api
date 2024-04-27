# Currency Converter API

This project is a currency converter API built using Spring Boot. It allows users to convert between different currencies using real-time exchange rates.

## Features

- Conversion between different currencies.
- Real-time exchange rates fetched from a reliable source.
- Support for multiple currencies.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) installed.
- Maven installed.
- IDE (e.g., IntelliJ IDEA, Eclipse, VS Code) for development.

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/rajeshsinha1997/currency-converter-api.git
2. Navigate to the project directory:

    ```bash
    cd currency-converter-api
3. Build the project using Maven:

    ```bash
    mvn clean install
## Usage

1. Run the application:

    ```bash
    mvn spring-boot:run
2. Once the application is running, you can access the API endpoints using a REST client such as Postman.

## API Endpoints

- **[GET] - /api/health** - Get Application Health
    - **Example:** /api/health

- **[GET] - /api/currency/convert** - Convert currency
    - **Parameters:**
        - from: The currency to convert from (e.g., USD)
        - to: The currency to convert to (e.g., EUR)
        - amount: The amount to convert
    - **Example:** /api/currency/convert?from=USD&to=INR&amount=100

## Configuration

The application uses external APIs to fetch real-time exchange rates. Make sure to configure the API keys and endpoints in the application.properties file.

## Contributing

Contributions are welcome! If you find any bugs or have suggestions for improvements, please open an issue or submit a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](./LICENSE) file for details.

