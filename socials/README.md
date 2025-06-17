# 📱 Spring Social Media API

A backend RESTful API built with Spring Boot for a social media application. It supports user registration, login, and CRUD operations on messages (posts).

---

## 🚀 Features

- ✅ User Registration & Login (with basic authentication)
- ✅ Create, Read, Update, Delete (CRUD) messages
- ✅ Get all messages or message by ID
- ✅ Exception handling with meaningful responses
- ✅ RESTful API structure using Spring MVC and Spring Data JPA
- ✅ PostgreSQL database support

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot
- Spring MVC
- Spring Data JPA
- PostgreSQL
- Maven
- Lombok

---

## 📂 Project Structure

src/
├── main/
│ ├── java/com/example/socialmedia/
│ │ ├── controller/
│ │ ├── service/
│ │ ├── repository/
│ │ ├── model/
│ │ └── exception/
│ └── resources/
│ ├── application.properties
├── test/


---

## 🔧 Setup Instructions

1. **Clone the repository**

```bash
git clone https://github.com/iamsharanshetty/Spring-Social_Media-API.git
cd Spring-Social_Media-API
```

2. **Configure the database**

Configure PostgreSQL in application.properties:

```bash
spring.application.name=socials
spring.datasource.driver-class-name = org.postgresql.Driver
spring.datasource.url = jdbc:postgresql://localhost:5432/social_app_db
spring.datasource.username = postgres
spring.datasource.password = Sharan@06
spring.jpa.hibernate.ddl-auto = update
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
```

## 📬 API Endpoints

1. **Acoount API**

| Method | Endpoint    | Description            |
| ------ | ----------- | ---------------------- |
| POST   | `/register` | Register a new user    |
| POST   | `/login`    | Login and authenticate |


2. **Message API**

| Method | Endpoint         | Description               |
| ------ | ---------------- | ------------------------- |
| GET    | `/messages`      | Get all messages          |
| GET    | `/messages/{id}` | Get a message by ID       |
| POST   | `/messages`      | Create a new message      |
| PATCH  | `/messages/{id}` | Update message text by ID |
| DELETE | `/messages/{id}` | Delete a message by ID    |
