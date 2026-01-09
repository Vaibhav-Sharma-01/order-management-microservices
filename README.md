# Order Management System – Microservices Architecture

This project is a Java full-stack microservices-based Order Management System
designed to demonstrate real-world backend architecture concepts using
Spring Boot, Spring Security, JWT, Kafka, Docker, and a React frontend.

The system is intentionally scoped to be small but complete, focusing on
correct architecture, security, and communication patterns rather than
feature bloat.

---

## Tech Stack

### Backend
- Java 17
- Spring Boot 3.x
- Spring Security (JWT-based authentication)
- Spring Data JPA
- PostgreSQL
- Apache Kafka

### Frontend
- React
- Axios

### Infrastructure
- Docker
- Docker Compose

---

## Microservices Overview

- **Auth Service**
  - Handles user registration and login
  - Issues JWT tokens
  - Central authority for authentication

- **User Service**
  - Manages user profile data
  - Requires valid JWT for access

- **Product Service**
  - Manages product catalog
  - Supports role-based access (ADMIN / USER)

- **Order Service**
  - Handles order placement
  - Publishes order events to Kafka

- **API Gateway**
  - Single entry point for all client requests
  - Routes requests to appropriate services
  - Centralized security handling

---

## Architecture Goals

- Stateless authentication using JWT
- Clear service boundaries
- Synchronous communication via REST
- Asynchronous communication via Kafka
- Containerized local development using Docker Compose

---

## Development Principles

- Each microservice has its own database
- No shared persistence between services
- DTO-based API contracts
- No direct entity exposure
- Explicit configuration over magic

---

## Project Status

🚧 Under active development  
This repository is built incrementally with clear Git history to reflect
real-world development practices.
