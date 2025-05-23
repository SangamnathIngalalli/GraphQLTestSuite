# SpaceX GraphQL API Testing Framework

A professional GraphQL automation testing framework built for testing the SpaceX GraphQL API (https://api.spacex.land/graphql/) using industry-standard tools and best practices.

## Technology Stack

- **Test Framework**: TestNG
- **HTTP Client**: RestAssured with GraphQL Support
- **Build Tool**: Gradle
- **Test Data Management**: JSON
- **Test Reporting**: Allure Reports
- **API**: SpaceX GraphQL API

## Project Structure

```
src/
├── main/
│   └── java/
│       └── com/
│           └── graphql/
│               └── test/
│                   ├── config/
│                   │   └── ConfigManager.java
│                   ├── models/
│                   ├── utils/
│                   │   └── SpaceXQueries.java
│                   └── services/
│                       └── GraphQLClient.java
└── test/
    ├── java/
    │   └── com/
    │       └── graphql/
    │           └── test/
    │               └── tests/
    │                   └── SpaceXGraphQLTest.java
    └── resources/
        ├── testdata/
        ├── queries/
        └── testng.xml
```

## Features

- GraphQL query/mutation testing for SpaceX API
- Comprehensive test coverage for:
  - Rockets information
  - Launch data
  - Ship details
  - Mission information
- Data-driven testing with JSON
- Detailed Allure reports
- Environment configuration management
- Reusable test components
- Logging and reporting

## Test Cases

The framework includes tests for:

1. **Rockets**
   - Fetch all SpaceX rockets
   - Verify rocket details (name, type, company, etc.)

2. **Launches**
   - Get latest 5 launches
   - Verify launch details
   - Check specific launch information

3. **Ships**
   - Fetch all SpaceX ships
   - Verify ship details and missions

## Setup Instructions

1. Clone the repository
2. Install Java JDK 11 or higher
3. Install Gradle
4. Create `src/test/resources/config.properties` with:
   ```properties
   base.url=https://api.spacex.land
   api.key=
   ```
5. Run the following commands:
   ```bash
   ./gradlew clean build
   ./gradlew allureReport
   ./gradlew allureServe
   ```

## Running Tests

```bash
# Run all tests
./gradlew test

# Run specific test class
./gradlew test --tests "com.graphql.test.tests.SpaceXGraphQLTest"

# Run specific test method
./gradlew test --tests "com.graphql.test.tests.SpaceXGraphQLTest.testRocketsQuery"
```

## Viewing Reports

After test execution, generate and view the Allure report:
```bash
./gradlew allureReport
./gradlew allureServe
```

## API Documentation

The framework tests the following SpaceX GraphQL API endpoints:

- `/graphql` - Main GraphQL endpoint
- Available Queries:
  - `rockets` - Get all rockets
  - `launches` - Get launch information
  - `ships` - Get ship details
  - `launch` - Get specific launch details

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details. 