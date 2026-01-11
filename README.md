# Feature Flag System

## Overview
This project is a **Feature Flag / Configuration Management System** built using **Java, Spring Boot, Spring Security, and MySQL**.

It allows application features to be **enabled or disabled at runtime** using **database-stored configuration**, without changing code or redeploying the application.

---

## Purpose of the Project
In real-world applications, changing feature behavior usually requires:
- code changes
- rebuilding the application
- redeployment

This project solves that problem by:
- storing feature configurations in the database
- reading configuration values at runtime
- dynamically controlling application behavior

---

## Core Features
- Create feature flags (Admin only)
- Enable or disable features at runtime
- Read feature status dynamically
- Role-based access control
- Clean layered backend architecture
- Global exception handling

---

## Tech Stack
- Java
- Spring Boot
- Spring Data JPA
- Spring Security (Basic Authentication)
- MySQL
- Hibernate

---

## Application Architecture
The application follows a **layered backend architecture**, where each layer has a clear responsibility.

### Controller Layer
- Handles HTTP requests and responses
- Exposes REST APIs
- Delegates business logic to the service layer

### Service Layer
- Contains core business logic
- Performs validation and feature state checks
- Acts as the central decision-making layer

### Repository Layer
- Handles database interaction using Spring Data JPA
- Fetches and persists feature flag data

### Database
- Stores feature flag configurations
- Feature values are read at runtime to control application behavior

---

## Security Integration
Security is integrated directly into the application architecture using **Spring Security**.

- **Basic Authentication** is used for authentication
- **Role-based authorization** is enforced:
    - `ADMIN` users can create and update feature flags
    - Public users can read feature status

Security is applied at the API layer and kept separate from business logic to maintain a clean and maintainable design.

---

## API Endpoints

### ➕ Create Feature (ADMIN)
POST /features?key=NEW_UI&enabled=true

### Update Feature (ADMIN)
PUT /features/NEW_UI?enabled=false


### Check Feature Status (Public)
GET /features/NEW_UI


### Info Endpoint
GET /features/info



## Runtime Feature Control
Feature flags are stored in the database and read **during request processing**.

Example usage in application logic:
```java
if (featureFlagService.isFeatureEnabled("NEW_UI")) {
    // New feature logic
} else {
    // Old feature logic
}
