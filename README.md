# QA Engineering Pipeline

A practical QA Engineering project focused on backend API testing, automated testing and CI/CD using Java, Spring Boot, JUnit 5, MockMvc, Maven and GitHub Actions.

The project is designed to gradually expand into a complete QA automation pipeline with API automation, integration testing, negative testing and continuous integration.

## Technologies

- Java 17
- Spring Boot
- Maven
- JUnit 5
- MockMvc
- Git
- GitHub
- GitHub Actions
- CI/CD

## Project Overview

The project contains a simple Spring Boot backend application with a health endpoint and automated API tests.

The main goal is to demonstrate how automated tests can be integrated into a CI pipeline and executed automatically when changes are pushed to GitHub.

## Backend

The backend is implemented using Spring Boot.

### Health Endpoint

```http
GET /health
```

The endpoint returns the current application status.

## Automated Tests

The project currently contains automated tests for:

- Verify that the `/health` endpoint returns HTTP 200.
- Verify that the `/health` endpoint returns the expected response body.
- Verify that an unknown endpoint returns HTTP 404.

The tests are implemented using JUnit 5 and MockMvc.

## Running Tests Locally

From the project root:

```bash
cd backend/backend
```

Run the Maven tests:

```bash
./mvnw test
```

On Windows:

```bash
mvnw.cmd test
```

All automated tests should pass successfully.

## CI/CD Pipeline

The project uses GitHub Actions to automatically execute the automated tests.

The workflow is located at:

```text
.github/workflows/ci.yml
```

The CI pipeline:

1. Checks out the repository.
2. Sets up Java 17.
3. Uses the Maven wrapper.
4. Runs the automated test suite.
5. Reports the test result in GitHub Actions.

The pipeline is triggered by pushes and pull requests to the `master` branch.

This allows automated tests to run automatically whenever changes are introduced into the repository.

## Project Structure

```text
QA-Engineering-Pipeline/
│
├── .github/
│   └── workflows/
│       └── ci.yml
│
├── backend/
│   └── backend/
│       ├── src/
│       │   ├── main/
│       │   │   └── java/
│       │   │       └── com/mario/backend/
│       │   │           ├── BackendApplication.java
│       │   │           └── HealthController.java
│       │   │
│       │   └── test/
│       │       └── java/
│       │           └── com/mario/backend/
│       │               ├── BackendApplicationTests.java
│       │               └── HealthControllerTest.java
│       │
│       ├── pom.xml
│       ├── mvnw
│       └── mvnw.cmd
│
└── README.md
```

## QA Engineering Goals

The project will gradually be expanded with:

- API automation
- Additional positive and negative test scenarios
- Integration testing
- More backend endpoints
- Test data management
- Improved CI/CD pipeline
- Test reporting

## Current Status

- Spring Boot backend implemented
- `/health` API endpoint implemented
- Automated API tests implemented
- Maven test execution configured
- Git repository configured
- GitHub repository configured
- GitHub Actions CI pipeline implemented
- CI pipeline successfully executes the automated tests

## Author

Mario Mladenov

QA Engineer | Manual & Automation Testing
