[![Java CI](https://github.com/Mario-Mladenov1998/QA-Engineering-Pipeline/actions/workflows/ci.yml/badge.svg)](https://github.com/Mario-Mladenov1998/QA-Engineering-Pipeline/actions/workflows/ci.yml)


# QA Engineering Pipeline

QA Engineering project demonstrating API testing, automated test execution and CI with GitHub Actions.

## Tech Stack

- Java 17
- Spring Boot
- Maven
- JUnit 5
- MockMvc
- GitHub Actions

## API

The project contains an Order REST API with:

- `POST /orders` - create an order
- `GET /orders/{id}` - get an existing order
- `PUT /orders/{id}` - update an order
- `DELETE /orders/{id}` - delete an order
- `GET /health` - health check

## Automated Tests

The API is covered by automated tests for:

- Successful order creation
- Order retrieval
- Order update
- Order deletion
- Validation of invalid quantities
- Non-existing orders
- HTTP status codes
- Response body validation
- Health endpoint

## CI

GitHub Actions automatically runs the Maven test suite on every push to the `master` branch and on pull requests.

The CI pipeline:

1. Checks out the repository
2. Sets up Java 17
3. Configures Maven
4. Runs the automated tests
5. Builds the project

## Running Tests Locally

Run:

```bash
./mvnw test