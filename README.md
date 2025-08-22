# Dashboard AI Backend

Backend application for Dashboard AI built with Spring Boot, PostgreSQL, and JWT authentication.

## Features

- **Spring Boot 3.2.1** with Java 17
- **PostgreSQL** database with Flyway migrations
- **JWT Authentication** and authorization
- **Spring Security** with role-based access control
- **OpenAPI/Swagger** documentation
- **MapStruct** for DTO mapping
- **Lombok** for reducing boilerplate code
- **Spring Data JPA** for database operations
- **Maven** build system

## Requirements

- Java 17 or higher
- PostgreSQL 12 or higher
- Maven 3.6 or higher

## Database Setup

1. Install PostgreSQL and create a database:
```sql
CREATE DATABASE dashboard_ai;
CREATE USER dashboard_user WITH ENCRYPTED PASSWORD 'dashboard_password';
GRANT ALL PRIVILEGES ON DATABASE dashboard_ai TO dashboard_user;
```

2. Update database connection in `application.properties` if needed.

## Running the Application

1. Clone the repository
2. Navigate to the backend directory: `cd backend_dashboardAI`
3. Run the application: `mvn spring-boot:run`

The application will start on `http://localhost:8080`

## API Documentation

Once the application is running, you can access:
- Swagger UI: `http://localhost:8080/api/swagger-ui.html`
- OpenAPI JSON: `http://localhost:8080/api/api-docs`

## Default Admin User

- Username: `admin`
- Password: `admin123`
- Email: `admin@dashboardai.com`

## API Endpoints

### Authentication
- `POST /api/auth/login` - User login

### Agents
- `GET /api/agents` - Get all agents (paginated)
- `GET /api/agents/{id}` - Get agent by ID
- `GET /api/agents/user/{userId}` - Get agents by user ID
- `POST /api/agents` - Create new agent
- `PUT /api/agents/{id}` - Update agent
- `DELETE /api/agents/{id}` - Delete agent
- `PATCH /api/agents/{id}/status` - Update agent status

## Configuration

Key configuration properties in `application.properties`:

- `spring.datasource.url` - Database connection URL
- `app.jwt.secret` - JWT secret key
- `app.jwt.expiration` - JWT token expiration time
- `app.cors.allowed-origins` - CORS allowed origins

## Building for Production

```bash
mvn clean package
java -jar target/backend-dashboardai-0.0.1-SNAPSHOT.jar
```

## Testing

Run tests with:
```bash
mvn test
```

## Architecture

The application follows a layered architecture:

- **Controller Layer**: REST endpoints
- **Service Layer**: Business logic
- **Repository Layer**: Data access
- **Entity Layer**: Database entities
- **DTO Layer**: Data transfer objects
- **Security Layer**: Authentication and authorization
- **Configuration Layer**: Application configuration

## Technologies Used

- Spring Boot 3.2.1
- Spring Security 6
- Spring Data JPA
- PostgreSQL
- Flyway
- JWT (JSON Web Tokens)
- MapStruct
- Lombok
- OpenAPI 3 / Swagger
- Maven
