# QA Engineering Pipeline

A QA Automation project focused on backend API testing using Java, Spring Boot, JUnit 5 and MockMvc.

## Technologies
- # Java 17
- Spring Boot
- Maven
- JUnit 5
- MockMvc
- Git
- GitHub

## Backend

The project contains a simple Spring Boot backend with a health endpoint.

### Health Endpoint

```http
GET /health

The endpoint returns the current application status.
Automated Tests
The project currently contains the following automated tests:
Verify that the /health endpoint returns HTTP 200.
Verify that the /health endpoint returns the expected response body.
Verify that an unknown endpoint returns HTTP 404.
Running the Tests
From the project root, run: cd backend
mvn test.

All automated tests should pass successfully.
QA-Engineering-Pipeline/
└── backend/
    ├── src/
    │   ├── main/
    │   │   └── java/
    │   │       └── com/mario/backend/
    │   │           ├── BackendApplication.java
    │   │           └── HealthController.java
    │   │
    │   └── test/
    │       └── java/
    │           └── com/mario/backend/
    │               ├── BackendApplicationTests.java
    │               └── HealthControllerTest.java
    │
    ├── pom.xml
    └── mvnw
Goal
The goal of this project is to build a practical QA Engineering pipeline and gradually expand it with API automation, integration testing, negative testing and CI/CD.
