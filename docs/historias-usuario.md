# Historias de Usuario - Rentadora SaaS

## Épica: Autenticación

### HU-001 - Iniciar Sesión

**Como** usuario del sistema

**Quiero** iniciar sesión con mi correo y contraseña

**Para** acceder a las funcionalidades permitidas según mi rol.

#### Criterios de Aceptación

* El usuario puede ingresar correo y contraseña.
* El sistema valida las credenciales.
* Si las credenciales son válidas, se genera un JWT.
* Si las credenciales son inválidas, se muestra un mensaje de error.

#### Prioridad

Alta

---

### HU-002 - Registrar Empleado

**Como** administrador

**Quiero** registrar empleados

**Para** permitirles acceder al sistema.

#### Criterios de Aceptación

* Se debe ingresar nombre completo.
* Se debe ingresar correo electrónico.
* Se debe ingresar contraseña.
* Se debe seleccionar un rol.
* El correo debe ser único.

#### Prioridad

Alta

---

### HU-003 - Registro de Cliente

**Como** visitante

**Quiero** crear una cuenta

**Para** poder realizar reservas.

#### Criterios de Aceptación

* Debo ingresar nombre.
* Debo ingresar apellido.
* Debo ingresar correo electrónico.
* Debo ingresar contraseña.
* El correo no puede existir previamente.
* El sistema asigna el rol CUSTOMER.

#### Prioridad

Alta

---

## Épica: Gestión de Vehículos

### HU-004 - Registrar Vehículo

**Como** administrador

**Quiero** registrar un vehículo

**Para** ofrecerlo en alquiler.

#### Criterios de Aceptación

* Se debe ingresar placa.
* Se debe ingresar marca.
* Se debe ingresar modelo.
* Se debe ingresar año.
* Se debe ingresar color.
* Se debe ingresar precio por día.
* La placa no puede repetirse.
* El vehículo queda en estado AVAILABLE.

#### Prioridad

Alta

---

### HU-005 - Actualizar Vehículo

**Como** administrador

**Quiero** actualizar la información de un vehículo

**Para** mantener la información actualizada.

#### Criterios de Aceptación

* El sistema permite editar la información.
* Los cambios quedan almacenados.

#### Prioridad

Media

---

### HU-006 - Desactivar Vehículo

**Como** administrador

**Quiero** desactivar un vehículo

**Para** impedir nuevas reservas.

#### Criterios de Aceptación

* El vehículo cambia a estado OUT_OF_SERVICE.
* El historial se conserva.

#### Prioridad

Media

---

### HU-007 - Consultar Vehículos Disponibles

**Como** cliente

**Quiero** visualizar los vehículos disponibles

**Para** seleccionar uno para mi reserva.

#### Criterios de Aceptación

* Se muestran únicamente vehículos disponibles.
* Se muestra marca, modelo, año y precio por día.
* Se permite búsqueda y filtrado.

#### Prioridad

Alta

---

## Épica: Gestión de Reservas

### HU-008 - Crear Solicitud de Reserva

**Como** cliente

**Quiero** solicitar la reserva de un vehículo

**Para** alquilarlo durante un período determinado.

#### Criterios de Aceptación

* Debo seleccionar un vehículo.
* Debo seleccionar fecha de inicio.
* Debo seleccionar fecha de fin.
* El vehículo debe estar disponible.
* La reserva queda en estado PENDING.

#### Prioridad

Alta

---

### HU-009 - Consultar Mis Reservas

**Como** cliente

**Quiero** visualizar mis reservas

**Para** conocer el estado de mis solicitudes.

#### Criterios de Aceptación

* Solo puedo visualizar mis reservas.
* Se muestran fechas y estado.

#### Prioridad

Alta

---

### HU-010 - Aprobar Reserva

**Como** empleado

**Quiero** aprobar una reserva

**Para** confirmar el alquiler del vehículo.

#### Criterios de Aceptación

* Debo visualizar reservas pendientes.
* Debo poder aprobar una reserva.
* El estado cambia a APPROVED.

#### Prioridad

Alta

---

### HU-011 - Rechazar Reserva

**Como** empleado

**Quiero** rechazar una reserva

**Para** informar que la solicitud no puede ser atendida.

#### Criterios de Aceptación

* Debo visualizar reservas pendientes.
* Debo poder rechazar una reserva.
* El estado cambia a REJECTED.

#### Prioridad

Alta

---

### HU-012 - Cancelar Reserva

**Como** cliente

**Quiero** cancelar una reserva pendiente

**Para** desistir de mi solicitud.

#### Criterios de Aceptación

* Solo puedo cancelar mis reservas.
* Solo pueden cancelarse reservas PENDING.
* El estado cambia a CANCELLED.

#### Prioridad

Media
