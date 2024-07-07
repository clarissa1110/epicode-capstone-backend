# Epicode Capstone Backend

This repository contains the source code for the backend of my [Epicode Capstone](https://github.com/clarissa1110/epicode-capstone-frontend) application. The backend is built using Java and Spring Boot, handling user operations, book collections, and authentication.

## Features

- User management (registration, login, create, update, delete)
- Book research calling on Google Books API
- Bookshelf management
- JWT-based authentication and authorization

## Prerequisites

- Java 11 or higher
- Maven
- A database (e.g., MySQL)

## Installation

1. Clone the repository:

    ```
    git clone https://github.com/clarissa1110/Epicode-capstone.git
    cd Epicode-capstone
    ```

2. Configure the database:

    Edit the `src/main/resources/application.properties` file with your database settings:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your_database
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
    ```

3. Build and run the application:

    ```
    mvn clean install
    mvn spring-boot:run
    ```

## API Endpoints

### Authentication

- **POST /auth/register**: Register a new user
- **POST /auth/login**: Log in a user

### Users

- **GET /api/users/{id}**: Retrieve user information

### Bookshelves

- **GET /api/bookshelves**: Retrieve all bookshelves for the logged-in user
- **POST /api/bookshelves**: Create a new bookshelf
- **GET /api/bookshelves/{id}/books**: Retrieve all books in a bookshelf
- **POST /api/bookshelves/{bookshelfId}/books/{bookId}**: Add a book to a bookshelf
- **DELETE /api/bookshelves/{bookshelfId}/books/{bookId}**: Remove a book from a bookshelf
