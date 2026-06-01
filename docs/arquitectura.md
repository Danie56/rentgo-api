# Arquitectura - RentGo

## Tecnologías

### Backend

* Java 21
* Spring Boot 3
* Spring Security
* JWT
* Spring Data JPA
* PostgreSQL
* Flyway
* Maven

### Frontend

* Angular
* Angular Material

### Infraestructura

* Docker
* Docker Compose

---

# Arquitectura Backend

## Estructura de paquetes

com.rentgo

├── auth
├── user
├── vehicle
├── reservation
├── common
├── config
└── exception

---

## Auth

Responsable de autenticación y autorización.

auth

├── controller
├── service
├── dto
├── mapper
└── security

---

## User

Responsable de la gestión de usuarios.

user

├── controller
├── service
├── repository
├── entity
├── dto
└── mapper

---

## Vehicle

Responsable de la gestión de vehículos.

vehicle

├── controller
├── service
├── repository
├── entity
├── dto
└── mapper

---

## Reservation

Responsable de la gestión de reservas.

reservation

├── controller
├── service
├── repository
├── entity
├── dto
└── mapper

---

## Common

Componentes reutilizables.

common

├── audit
├── enums
├── response
└── util

---

## Config

Configuraciones globales.

config

├── SecurityConfig
├── OpenApiConfig
└── JpaConfig

---

## Exception

Manejo centralizado de excepciones.

exception

├── BusinessException
├── ResourceNotFoundException
└── GlobalExceptionHandler

---

# Principios

* Arquitectura modular por dominio.
* Separación entre entidades y DTOs.
* Uso de Flyway para migraciones.
* Uso de JWT para autenticación.
* Uso de UUID como identificador principal.
