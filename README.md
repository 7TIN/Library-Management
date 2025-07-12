# Library Management

A simple **Library Management System** built with **Spring Boot**.  
This RESTful API allows you to manage books: add, view, update availability, and delete records.

## Features

- Add new books
- Retrieve all books
- Get book details by ID
- Update book availability
- Delete books
- RESTful endpoints using Spring Boot
- Postman collection for API testing

## Getting Started

### Prerequisites

- Java 17 or above
- Maven 3.8+
- (Optional) Postman for API testing

### Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/7TIN/Library-Management.git
   cd Library-Management
   ```

2. **Build the project**
   ```bash
   ./mvnw clean install
   ```

3. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```
   The API will start at: `http://localhost:8080`

## API Endpoints

| Method | Endpoint                       | Description                          |
|--------|------------------------------- |--------------------------------------|
| POST   | `/api/books`                   | Add a new book                       |
| GET    | `/api/books`                   | Get all books                        |
| GET    | `/api/books/{id}`              | Get book by ID                       |
| PATCH  | `/api/books/avail/{id}`        | Update book availability             |
| DELETE | `/api/books/{id}`              | Delete book by ID                    |

### Example JSON for Adding a Book

```json
{
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "isbn": "9780132350884"
}
```

### Example: Update Availability

```http
PATCH /api/books/avail/{id}
```

## Testing with Postman

[![Run in Postman](https://run.pstmn.io/button.svg)](https://postman.com/collections/42398638-5ce8481e-192d-4eee-b6cd-4f4435949c71?action=share&workspace=79d4edcf-3954-4037-8940-bb3e29610160)

2. Use the sample requests to test all endpoints.

<!-- *To generate a Postman collection link:*
- In Postman, right-click your collection > Share Collection > Get public link, and paste the link here. -->

## Project Structure

```
src/
 └── main/
     ├── java/
     │   └── com/prasad/library/
     │       ├── Beans/
     │       ├── Controller/
     │       ├── Repository/
     │       ├── Service/
     │       └── dto/
     └── resources/
         └── application.properties
```

## Best Practices

- Uses DTOs for request/response mapping
- Follows RESTful resource naming conventions
- Proper HTTP status codes and error handling
- Separation of concerns: Controller, Service, Repository layers

## License

This project is open source and available under the [MIT License](LICENSE).

<!-- **Tip:**  
For more information on REST API best practices in Spring Boot, see [Spring Boot REST API Best Practices][2].  
To document your API, consider integrating Swagger/OpenAPI as described [here][7].

[2]: https://amigoscode.com/blogs/top-10-spring-boot-rest-api-best-practices  
[7]: https://www.baeldung.com/spring-rest-openapi-documentation

[1] https://github.com/7TIN/Library-Management
[2] https://amigoscode.com/blogs/top-10-spring-boot-rest-api-best-practices
[3] https://www.youtube.com/watch?v=EgQJRB9Vs3Y
[4] https://www.geeksforgeeks.org/advance-java/best-practices-while-making-rest-apis-in-spring-boot-application/
[5] https://spring.io/guides/tutorials/rest
[6] https://www.sivalabs.in/spring-boot-rest-api-best-practices-part-1/
[7] https://www.baeldung.com/spring-rest-openapi-documentation
[8] https://spring.io/guides/gs/testing-restdocs
[9] https://apidog.com/blog/spring-boot-api-documentation/ -->