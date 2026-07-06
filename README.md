# Enterprise Banking REST API

Production-oriented banking API built with Java 21 and Spring Boot 3. The codebase demonstrates clean layering, transactional money movement, JWT authentication, Flyway-managed schema, validation, global error handling, audit logging, pagination, sorting, and tests.

## Project Architecture

The project follows Clean Architecture with pragmatic Spring layering:

- `domain`: framework-light business models, repository ports, and business exceptions.
- `application`: use-case services for authentication, customers, accounts, and transactions.
- `infrastructure`: Spring Security, JWT, JPA entities, Spring Data repositories, persistence adapters, audit filter, and configuration.
- `interfaces`: REST controllers, request/response DTOs, validation, and global exception handling.

Money movement is handled inside `@Transactional` service methods. Account rows are loaded with pessimistic write locks during balance updates, so concurrent deposits, withdrawals, and transfers do not overwrite balances.

## Folder Structure

```text
src/main/java/com/enterprisebank/banking
  application/       Use cases and service layer
  domain/            Domain records, enums, repository interfaces, exceptions
  infrastructure/    JPA, security, audit, OpenAPI, external adapters
  interfaces/rest/   Controllers, DTOs, validation, exception advice
src/main/resources/db/migration
  V1__init_schema.sql
  V2__seed_admin_user.sql
```

## Technologies Used

Java 21, Spring Boot 3, Spring Security, JWT, Spring Data JPA, Hibernate, PostgreSQL, Flyway, Docker, Docker Compose, Maven, Lombok, MapStruct, Swagger OpenAPI, SLF4J/Logback, JUnit 5, Mockito, H2 for integration tests, and GitHub Actions.

## How to Run

Local PostgreSQL must be available at `localhost:5432` with database `enterprise_bank`, username `bank_user`, and password `bank_password`, or override the `SPRING_DATASOURCE_*` environment variables.

```bash
mvn spring-boot:run
```

Swagger UI:

```text
http://localhost:8080/swagger-ui.html
```

## Docker Commands

```bash
docker compose up --build
docker compose down
docker compose down -v
```

The API runs on `http://localhost:8080`.

## Authentication

Public endpoints:

- `POST /api/v1/auth/register`
- `POST /api/v1/auth/login`
- `POST /api/v1/auth/refresh`

Protected endpoints require:

```http
Authorization: Bearer <accessToken>
```

Flyway seeds a local admin account for development:

- username: `admin`
- password: `password`

Rotate or remove this seeded account before any non-local deployment.

## API Overview

- Customers: CRUD with pagination, sorting, and filtering by `query`.
- Accounts: open account, close account, retrieve account, list by customer.
- Transactions: deposit, withdraw, transfer, and account transaction history.
- Audit: every `/api/**` operation is recorded with user, date, endpoint, operation, and status code.

Example paged request:

```text
GET /api/v1/customers?query=john&page=0&size=20&sort=createdAt,desc
```

## Error Handling

Errors use a consistent JSON structure:

```json
{
  "timestamp": "2026-07-06T00:00:00Z",
  "status": 422,
  "error": "Unprocessable Entity",
  "message": "Insufficient funds",
  "path": "/api/v1/transactions/transfer"
}
```

Validation failures include `fieldErrors`.

## Testing

```bash
mvn test
```

The test suite includes service-level unit tests with Mockito and integration tests with MockMvc, Spring Security, Flyway, and H2 in PostgreSQL compatibility mode.

## Future Improvements

- Add Testcontainers-backed PostgreSQL integration tests.
- Add account statements and export endpoints.
- Add idempotency keys for money movement endpoints.
- Add rate limiting and login attempt throttling.
- Add outbox events for downstream ledger and notification systems.
- Add separate provisioning flow for staff users and role management.
