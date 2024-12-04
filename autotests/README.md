# Web Automation and API Testing Project

## Overview
This project is a Java-based application that utilizes several frameworks and libraries to provide a comprehensive solution for web automation and API testing. The project is structured using Maven for dependency management and build automation.

---

## Algorithms
The project implements various algorithms for web automation and API testing. These algorithms are designed to interact with web elements, perform actions, and validate responses. Key algorithms include:

### WebDriver Initialization
- **Description**: Sets up the WebDriver for browser automation using Selenium.
  
### API Request Handling
- **Description**: Handles API requests and responses using RestAssured.
  
### Authentication
- **Description**: Manages user authentication by sending login requests and handling tokens.

---

## Frameworks and Libraries

### Selenium WebDriver
- **Why Used**: Automates web application testing, allowing simulation of user interactions with web pages.
- **How Used**: The `WebDriverFactory` class initializes the WebDriver with `ChromeDriver` and sets up Chrome options.

### RestAssured
- **Why Used**: Simplifies the process of testing RESTful web services by sending HTTP requests and validating responses.
- **How Used**: The `ProductAPITest` class uses RestAssured to send login requests and retrieve product information.

### JUnit
- **Why Used**: Provides annotations and assertions for writing and running tests.
- **How Used**: The `ProductAPITest` class uses JUnit annotations like `@Before` and `@Test` to define test methods and setup procedures.

### Maven
- **Why Used**: Manages project dependencies and automates the build process.
- **How Used**: The `pom.xml` file defines project dependencies and build configurations.

---

## Use Case Scenarios

### Scenario 1: User Login and Product Retrieval
**Description**: This scenario involves a user logging into the application and retrieving a list of products.

**Steps**:
1. The user sends a login request with their phone number and password.
2. The application validates the credentials and returns an authentication token.
3. The user sends a request to retrieve all products using the authentication token.
4. The application returns a list of products.

**Illustration**:
```plaintext
+----------------+       +----------------+       +----------------+
| User           |       | Application    |       | Database       |
+----------------+       +----------------+       +----------------+
| POST /login    | ----> | Validate creds | ----> | Check user     |
|                |       |                |       |                |
|                |       | Return token   | <---- |                |
|                | <---- |                |       |                |
| GET /products  | ----> | Validate token |       |                |
|                |       | Return products|       |                |
|                | <---- |                |       |                |
+----------------+       +----------------+       +----------------+
```

---

### Scenario 2: Web Automation for Form Submission
**Description**: This scenario involves automating the submission of a web form.

**Steps**:
1. The WebDriver navigates to the form page.
2. The WebDriver fills in the form fields with the required data.
3. The WebDriver submits the form.
4. The application processes the form submission and returns a success message.

**Illustration**:
```plaintext
+----------------+       +----------------+       +----------------+
| WebDriver      |       | Web Page       |       | Application    |
+----------------+       +----------------+       +----------------+
| Navigate to    | ----> | Load form      |       |                |
| form page      |       |                |       |                |
| Fill form      | ----> |                |       |                |
| fields         |       |                |       |                |
| Submit form    | ----> |                |       | Process form   |
|                |       | Return success | <---- | message        |
+----------------+       +----------------+       +----------------+
```

---

### Scenario 3: API Testing for User Registration
**Description**: This scenario involves testing the user registration API.

**Steps**:
1. The user sends a registration request with their details.
2. The application validates the details and creates a new user account.
3. The application returns a success message and user details.

**Illustration**:
```plaintext
+----------------+       +----------------+       +----------------+
| User           |       | Application    |       | Database       |
+----------------+       +----------------+       +----------------+
| POST /register | ----> | Validate details| ----> | Create user    |
|                |       | Return success | <---- |                |
|                | <---- | message        |       |                |
+----------------+       +----------------+       +----------------+
```

---

## Conclusion
This project leverages powerful frameworks and libraries to provide robust solutions for web automation and API testing. The detailed algorithms and use case scenarios illustrate the comprehensive capabilities of the application.




