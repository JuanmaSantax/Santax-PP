# Santax-PP

🏗 FASE 1 — Diseño formal del sistema

Primero definimos bien el modelo conceptual (como si lo presentaras en una empresa).

🎯 1️⃣ Modelo Entidad–Relación (diseño correcto)
🚗 Vehiculo

Representa un auto único identificado por patente.

Atributos:

id (PK)

patente (UNIQUE)

marca

modelo

anio

codigoColorOriginal

🧾 OrdenTrabajo

Cada vez que un auto ingresa al taller.

Atributos:

id (PK)

fechaIngreso

fechaEgreso

descripcionGeneral

vehiculo_id (FK)

Relación:
Vehiculo (1) —— (N) OrdenTrabajo

🎨 AjusteColor

Puede haber más de un ajuste en una orden.

Atributos:

id (PK)

codigoColorBase

proveedorPintura

huboRetoque (boolean)

descripcionRetoque

formulaFinal

ordenTrabajo_id (FK)

Relación:
OrdenTrabajo (1) —— (N) AjusteColor

🧩 ZonaReparada

Atributos:

id (PK)

nombreZona

detalleTrabajo

ordenTrabajo_id (FK)

Relación:
OrdenTrabajo (1) —— (N) ZonaReparada

📊 Esquema relacional resumido
VEHICULO (id PK, patente UNIQUE, marca, modelo, anio, codigo_color_original)

ORDEN_TRABAJO (id PK, fecha_ingreso, fecha_egreso, descripcion, vehiculo_id FK)

AJUSTE_COLOR (id PK, codigo_color_base, proveedor, hubo_retoque, descripcion_retoque, formula_final, orden_id FK)

ZONA_REPARADA (id PK, nombre_zona, detalle, orden_id FK)
🧠 Decisiones técnicas importantes

✔ No usamos patente como PK → usamos id autoincremental
✔ Patente tiene constraint UNIQUE
✔ Relaciones 1..N bien definidas
✔ Modelo normalizado

🏗 FASE 2 — Arquitectura Backend

Vamos a usar:

Spring Boot

Spring Data JPA

PostgreSQL

📦 Estructura profesional de paquetes
com.taller

├── config
├── controller
│     ├── VehiculoController
│     ├── OrdenController
│     ├── AjusteColorController
│
├── service
│     ├── VehiculoService
│     ├── OrdenService
│
├── repository
│     ├── VehiculoRepository
│     ├── OrdenRepository
│
├── model
│     ├── Vehiculo
│     ├── OrdenTrabajo
│     ├── AjusteColor
│     ├── ZonaReparada
│
└── dto
🔌 API REST que vas a implementar
Vehiculos
POST   /api/vehiculos
GET    /api/vehiculos
GET    /api/vehiculos/{patente}
Ordenes
POST   /api/ordenes
GET    /api/ordenes/vehiculo/{patente}
Ajustes
POST   /api/ajustes
GET    /api/ajustes/orden/{id}
📱 FASE 3 — Frontend simple

Vamos a hacerlo con:

HTML

CSS

JavaScript

Fetch API

Después lo convertimos en APK con:

Capacitor

🗓 Plan de trabajo semanal (realista)
🔹 Semana 1

Crear proyecto Spring Boot

Configurar BD

Crear entidades JPA

Crear repositories

🔹 Semana 2

Crear servicios

Crear controladores

Probar endpoints con Postman

🔹 Semana 3

Hacer frontend básico

Formularios

Consumo API

🔹 Semana 4

Integración completa

Mejorar UI

Generar APK

🚀 Ahora empezamos en serio

Vamos a hacer el primer paso práctico:

1️⃣ Crear proyecto Spring Boot

Dependencias:

Spring Web

Spring Data JPA

PostgreSQL Driver

Lombok (opcional)
