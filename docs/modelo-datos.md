# Modelo de Datos - Rentadora SaaS

## Entidad User

Representa cualquier usuario autenticado en el sistema.

### Atributos

| Campo      | Tipo         | Restricciones |
| ---------- | ------------ | ------------- |
| id         | UUID         | PK            |
| first_name | VARCHAR(100) | NOT NULL      |
| last_name  | VARCHAR(100) | NOT NULL      |
| email      | VARCHAR(255) | UNIQUE        |
| password   | VARCHAR(255) | NOT NULL      |
| role       | ENUM         | NOT NULL      |
| created_at | TIMESTAMP    | NOT NULL      |
| updated_at | TIMESTAMP    | NOT NULL      |

### Roles

* ADMIN
* EMPLOYEE
* CUSTOMER

---

## Entidad Vehicle

Representa un vehículo disponible para alquiler.

### Atributos

| Campo       | Tipo          | Restricciones |
| ----------- | ------------- | ------------- |
| id          | UUID          | PK            |
| plate       | VARCHAR(20)   | UNIQUE        |
| brand       | VARCHAR(100)  | NOT NULL      |
| model       | VARCHAR(100)  | NOT NULL      |
| year        | INTEGER       | NOT NULL      |
| color       | VARCHAR(50)   | NOT NULL      |
| daily_price | DECIMAL(10,2) | NOT NULL      |
| status      | ENUM          | NOT NULL      |
| created_at  | TIMESTAMP     | NOT NULL      |
| updated_at  | TIMESTAMP     | NOT NULL      |

### Estados

* AVAILABLE
* RENTED
* MAINTENANCE
* OUT_OF_SERVICE

---

## Entidad Reservation

Representa una solicitud de alquiler.

### Atributos

| Campo      | Tipo      | Restricciones |
| ---------- | --------- | ------------- |
| id         | UUID      | PK            |
| user_id    | UUID      | FK            |
| vehicle_id | UUID      | FK            |
| start_date | DATE      | NOT NULL      |
| end_date   | DATE      | NOT NULL      |
| status     | ENUM      | NOT NULL      |
| created_at | TIMESTAMP | NOT NULL      |
| updated_at | TIMESTAMP | NOT NULL      |

### Estados

* PENDING
* APPROVED
* REJECTED
* ACTIVE
* COMPLETED
* CANCELLED

---

## Relaciones

### User → Reservation

Un usuario puede tener muchas reservas.

```text
User 1 ------ N Reservation
```

---

### Vehicle → Reservation

Un vehículo puede aparecer en múltiples reservas a lo largo del tiempo.

```text
Vehicle 1 ------ N Reservation
```

---

## Reglas de Negocio

### Reservas

* La fecha de inicio debe ser menor que la fecha de fin.
* No se permiten reservas solapadas para un mismo vehículo.
* Solo usuarios con rol CUSTOMER pueden crear reservas.

### Vehículos

* La placa debe ser única.
* Solo vehículos AVAILABLE pueden reservarse.

### Usuarios

* El correo electrónico debe ser único.
* La contraseña debe almacenarse cifrada usando BCrypt.
