# Library Management System

## Overview
A simple Library Management System built using Spring Boot and MySQL. This project allows managing books, members, and lending records through a RESTful API. It demonstrates CRUD operations, database connectivity, and efficient use of Java data structures.

---

## Features
- Add, update, retrieve, and delete books.
- RESTful API endpoints for managing library data.
- MySQL database integration using Spring Data JPA.
- Efficient data handling with modern Java practices.

---

## Getting Started

### Prerequisites
- **Java 17** or later
- **MySQL 8.x**
- **Maven**

### Setup Instructions
1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-repo-name/library-management-system.git
   cd library-management-system
   ```

2. **Configure the MySQL Database**:
   - Create a database:
     ```sql
     CREATE DATABASE library_db;
     ```
   - Update the `application.properties` file with your MySQL credentials.

3. **Build the project**:
   ```bash
   mvn clean install
   ```

4. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

5. **Access the API**:
   - Base URL: `http://localhost:8080/api/books`

---

## API Endpoints

### Book Endpoints
| Method | Endpoint           | Description                     |
|--------|--------------------|---------------------------------|
| GET    | `/api/books`       | Retrieve all books              |
| GET    | `/api/books/{id}`  | Retrieve a book by ID           |
| POST   | `/api/books`       | Add a new book                  |
| PUT    | `/api/books/{id}`  | Update an existing book by ID   |
| DELETE | `/api/books/{id}`  | Delete a book by ID             |

---

## Configuration

### `application.properties`
This file contains the configuration for database connection, Hibernate settings, and connection pooling.
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/library_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## Dependencies
- **Spring Boot Starter Web**: For building RESTful APIs.
- **Spring Boot Starter Data JPA**: For database interaction.
- **MySQL Connector**: For connecting to MySQL database.
- **HikariCP**: Connection pooling.

---



