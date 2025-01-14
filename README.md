# Internship-Assignment
A Spring Boot application to calculate the cheapest transfer route for a logistics company, ensuring maximum cost efficiency while adhering to weight constraints.


## Requirements
  -Java 21 (or later)
  -Maven for building and dependency management
  -Postman or curl for API testing

## Features
  -API Endpoint: /api/transfers/cheapest-route
  -Accepts a POST request with a JSON body containing available transfers and a maximum weight limit.
  -Returns a JSON response with the selected transfers, total cost, and total weight.

## Example Input
  To test the endpoint, you can use the following example input in curl or Postman.
**Request:** ```bash
           curl -X POST http://localhost:9090/api/transfers/cheapest-route -H "Content-Type: application/json" -d "{\"maxWeight\": 15, \"availableTransfers\": [{\"weight\": 5, \"cost\": 10}, {\"weight\": 10, \"cost\": 20}, {\"weight\": 3, \"cost\": 5}, {\"weight\": 8, \"cost\": 15}]}"
           curl -X POST http://localhost:9090/api/transfers/cheapest-route -H "Content-Type: application/json" -d "{\"maxWeight\": 2, \"availableTransfers\": [{\"weight\": 5, \"cost\": 10}, {\"weight\": 6, \"cost\": 15}]}"
 
## How to Build and Run the Application
1. Clone the Repository
Clone the GitHub repository to your local machine:
git clone https://github.com/yourusername/cheapest-transfer-route.git

3. Build the Application
Navigate to the project folder and run the following command to build the application:
mvn clean install

3. Run the Application
After building, run the application using the command below:
-If you are in the project's root directory:
java -jar target/cheapest-transfer-route-0.0.1-SNAPSHOT.jar
-If you are inside the target directory:
java -jar cheapest-transfer-route-0.0.1-SNAPSHOT.jar


This will start the application on port 9090 by default.


## Running Tests
Unit Tests
Unit tests are available for the service layer and the logic behind selecting the best 
combination of transfers. You can run the tests using:
mvn test

## Integration Tests
Integration tests are included for testing the API endpoints. These tests verify that the application 
responds as expected to various inputs. Run the integration tests with:
mvn verify

## Technologies Used
-Java 21
-Spring Boot 3
-Maven for building and dependency management
-JUnit 5 for unit testing

