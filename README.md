# 📧 ByteForge User Service

A Java Spring Boot microservice for user registration, email verification, and secure password management using PostgreSQL, RabbitMQ, and MailHog for local email testing.

---

## 📦 Features

- 📑 User registration with email and strong password validation
- 📬 Email verification via unique token links
- 🐰 RabbitMQ integration for asynchronous email processing
- 🛡️ Password encryption with BCrypt
- 🗄️ Database version control via Flyway migrations
- 🐳 Docker Compose environment for PostgreSQL, RabbitMQ, and MailHog
- 📖 Swagger UI for real-time API documentation
- 📦 Gradle-based project setup

---

## 📊 Application Flow

1. **User Registration**  
   A client sends a **POST** request to the `Users API` endpoint with user details (email and password).

2. **User Creation & Queue Dispatch**  
   The application:
   - Validates the request and encrypts the password  
   - Creates a new user record in the **PostgreSQL** database with a unique verification token  
   - Sends an email message to a **RabbitMQ queue** containing the verification link  

3. **Message Listener Processing**  
   A **RabbitMQ message listener** waits for incoming messages on the queue. Once a message is received, it sends the verification email to the user via **MailHog (SMTP server)**.

4. **Email Verification**  
   The user clicks the verification link received in their email. This triggers a **GET** request to the `Verify User` endpoint, passing the unique token as a query parameter.

5. **User Status Update**  
   The application verifies the token. If valid, it updates the user's `is_verified` status in the **PostgreSQL** database to `true`.

6. **Confirmation Response**  
   The application returns a success response indicating that the user's email has been successfully verified.

---

## 🖥️ Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA
- Spring Validation
- RabbitMQ
- MailHog (SMTP for local testing)
- Flyway
- PostgreSQL
- Docker & Docker Compose
- Swagger (springdoc-openapi)

---

## 🚀 Getting Started

### 📦 Run the full environment (PostgreSQL, RabbitMQ, MailHog)

```bash
docker-compose up -d
