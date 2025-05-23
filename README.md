# GraphQL Automation Testing Framework

This is a professional GraphQL automation testing framework built with industry-standard tools and best practices.

## Technology Stack

- **Test Framework**: TestNG
- **HTTP Client**: RestAssured with GraphQL Support
- **Build Tool**: Gradle
- **Test Data Management**: JSON
- **Test Reporting**: Allure Reports

## Project Structure

```
src/
├── main/
│   └── java/
│       └── com/
│           └── graphql/
│               └── test/
│                   ├── config/
│                   ├── models/
│                   ├── utils/
│                   └── services/
└── test/
    ├── java/
    │   └── com/
    │       └── graphql/
    │           └── test/
    │               ├── tests/
    │               └── steps/
    └── resources/
        ├── testdata/
        ├── queries/
        └── testng.xml
```

## Setup Instructions

1. Clone the repository
2. Install Java JDK 11 or higher
3. Install Gradle
4. Run the following commands:
   ```bash
   ./gradlew clean build
   ./gradlew allureReport
   ./gradlew allureServe
   ```

## Running Tests

```bash
./gradlew test
```

## Viewing Reports

After test execution, generate and view the Allure report:
```bash
./gradlew allureReport
./gradlew allureServe
```

## Features

- GraphQL query/mutation testing
- Data-driven testing with JSON
- Detailed Allure reports
- Environment configuration management
- Reusable test components
- Logging and reporting 