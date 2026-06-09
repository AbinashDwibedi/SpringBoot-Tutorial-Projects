# 🍃 Spring Boot Tutorial Projects

A collection of Spring Boot projects built while following along with tutorials — progressing from the basics of dependency injection to building full REST APIs and data-driven applications with JPA & PostgreSQL.

---

## 📂 Projects

| #   | Project                                    | Description                                        | Key Concepts                                           |
| --- | ------------------------------------------ | -------------------------------------------------- | ------------------------------------------------------ |
| 1   | [demo](./demo)                             | Starter project exploring Spring fundamentals      | IoC, DI, Beans, Conditional Beans                      |
| 2   | [restAPI](./restAPI)                       | CRUD REST API for student management               | REST Controllers, DTOs, Validation, JPA                |
| 3   | [hospitalManagement](./hospitalManagement) | Hospital management system with complex data model | Entity Relationships, JPQL, Pagination, Custom Queries |

---

### 1️⃣ `demo` — Spring Boot Basics

A minimal project to understand the core building blocks of the Spring framework.

**Concepts Covered:**

- Creating a Spring Boot application from scratch
- `@RestController` & `@GetMapping` — Hello World endpoint
- Dependency Injection — Field injection vs Constructor injection
- Interface-based abstraction (`PaymentService` interface)
- `@Component` & `@ConditionalOnProperty` — conditional bean registration (Razorpay / Stripe)
- `CommandLineRunner` for executing logic at startup

**Tech Stack:** `Spring Boot 3.5` · `Spring Web` · `Java 21` · `Maven`

---

### 2️⃣ `restAPI` — Student CRUD REST API

A complete RESTful API implementing all CRUD operations with proper layered architecture.

**Concepts Covered:**

- Layered architecture — Controller → Service → Repository
- `@RestController` with `@RequestMapping`, `@GetMapping`, `@PostMapping`, `@PutMapping`, `@PatchMapping`, `@DeleteMapping`
- DTO pattern — `StudentDto`, `AddStudentRequestDto`
- Bean Validation — `@NotBlank`, `@Email`, `@Size`
- `ResponseEntity` with proper HTTP status codes (`200`, `201`, `204`)
- ModelMapper for Entity ↔ DTO conversion
- Partial updates with `@PatchMapping` using `Map<String, Object>`
- Spring Data JPA with PostgreSQL
- Auto DDL with `spring.jpa.hibernate.ddl-auto=update`

**Tech Stack:** `Spring Boot 3.5` · `Spring Web` · `Spring Data JPA` · `Spring Validation` · `PostgreSQL` · `Lombok` · `ModelMapper` · `Java 21` · `Maven`

**API Endpoints:**

| Method   | Endpoint             | Description                 |
| -------- | -------------------- | --------------------------- |
| `GET`    | `/api/students`      | Get all students            |
| `GET`    | `/api/students/{id}` | Get student by ID           |
| `POST`   | `/api/students`      | Create a new student        |
| `PUT`    | `/api/students/{id}` | Full update of a student    |
| `PATCH`  | `/api/students/{id}` | Partial update of a student |
| `DELETE` | `/api/students/{id}` | Delete a student            |

---

### 3️⃣ `hospitalManagement` — Hospital Management System

A more advanced project focused on JPA entity relationships, custom queries, and data modeling for a hospital domain.

**Concepts Covered:**

- Complex entity relationships:
  - `@OneToOne` — Patient ↔ Insurance (with `@JoinColumn`, owning/inverse sides)
  - `@OneToMany` / `@ManyToOne` — Patient ↔ Appointments, Doctor ↔ Appointments
  - `@ManyToMany` — Department ↔ Doctor (with `@JoinTable`)
- `@Enumerated(EnumType.STRING)` — Blood group types
- `@CreationTimestamp` for automatic audit fields
- Table customization — `@Table`, `@UniqueConstraint`, `@Index`
- Cascade types — `PERSIST`, `MERGE`, `REMOVE` & `orphanRemoval`
- Fetch strategies — `FetchType.LAZY` vs `EAGER` (N+1 problem awareness)
- Spring Data JPA query methods (derived queries)
- JPQL — `@Query` with positional & named parameters
- Native SQL queries
- DTO projections in JPQL
- Pagination with `Pageable` & `Page`
- `@Modifying` & `@Transactional` for update queries
- `JOIN FETCH` to solve N+1 query problem
- Service layer with business logic
- SQL data initialization with `data.sql`

**Entities:**

```
Patient ──── 1:1 ──── Insurance
   │
   └──── 1:N ──── Appointment ──── N:1 ──── Doctor
                                              │
                                     N:M ──── Department
```

**Tech Stack:** `Spring Boot 4.0` · `Spring Web MVC` · `Spring Data JPA` · `PostgreSQL` · `Lombok` · `Java 21` · `Maven`

---

## 🛠️ Prerequisites

- **Java 21** or later
- **Maven 3.9+**
- **PostgreSQL** (running locally on port `5432`)
- Create the required databases:
  ```sql
  CREATE DATABASE studentdb;
  CREATE DATABASE hospitaldb;
  ```

## 🚀 How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/AbinashDwibedi/SpringBoot-Tutorial-Projects.git
   cd SpringBoot-Tutorial-Projects
   ```

2. Navigate into any project and run:

   ```bash
   cd restAPI   # or demo / hospitalManagement
   ./mvnw spring-boot:run
   ```

3. The application will start on `http://localhost:8080`
   > The `restAPI` and `hospitalManagement` projects use the context path `/api`

---

## 📚 Learning Progression

```
demo (Basics)
  └─→ Spring IoC, DI, Beans, Conditional Beans

restAPI (Intermediate)
  └─→ REST APIs, CRUD, DTOs, Validation, JPA Basics

hospitalManagement (Advanced)
  └─→ Entity Relationships, JPQL, Pagination, N+1 Problem
```

---

## 🧰 Tech Stack Summary

| Technology      | Version   |
| --------------- | --------- |
| Java            | 21        |
| Spring Boot     | 3.5 / 4.0 |
| Spring Data JPA | ✅        |
| PostgreSQL      | ✅        |
| Lombok          | ✅        |
| ModelMapper     | 3.2.4     |
| Maven           | ✅        |

---

> **Note:** These are tutorial/learning projects. Database credentials in `application.properties` are for local development only.
