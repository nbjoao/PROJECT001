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
