# Ecosistema de Salud Unificado (ESU)
> Plataforma integral B2B2C para la modernización y centralización de servicios de salud en Cruz del Eje.

---

## Tabla de Contenidos
1. [Visión General](#visión-general)
2. [Arquitectura y Tecnologías](#arquitectura-y-tecnologías)
3. [Perfiles y Funcionalidades](#perfiles-y-funcionalidades)
4. [Flujo de Funcionamiento](#flujo-de-funcionamiento)
5. [Gestión de Proyecto (PMI)](#gestión-de-proyecto-pmi)
6. [Roadmap de Desarrollo](#roadmap-de-desarrollo)
7. [Instalación y Configuración](#instalación-y-configuración)
8. [Equipo de Desarrollo](#equipo-de-desarrollo)

---

## Visión General
El **Ecosistema de Salud Unificado (ESU)** nace para resolver la fragmentación de los servicios médicos en Cruz del Eje. El proyecto reemplaza procesos manuales por un sistema digital interoperable que centraliza la gestión de turnos, historias clínicas y comunicación entre pacientes y profesionales.

* **Propósito:** Facilitar el acceso a la salud y mejorar la organización sistémica.
* **Impacto:** Reducción del ausentismo mediante listas de espera inteligentes y recordatorios automáticos.

---

## Arquitectura y Tecnologías
El sistema utiliza una arquitectura moderna basada en microservicios y BaaS (Backend as a Service) para garantizar escalabilidad y seguridad.


El sistema está desarrollado bajo una arquitectura cliente-servidor robusta, priorizando la modularidad, la seguridad de los datos médicos y la escalabilidad del sistema:

| Capa | Tecnología | Función |
| :--- | :--- | :--- |
| **Frontend** | HTML5 + CSS3 + JavaScript (react)| Interfaz de usuario estructurada, adaptativa y reactiva. |
| **Backend** | Java + Spring Boot | Motor de la API REST, lógica de negocio y control de accesos. |
| **Base de Datos** | MySQL | Persistencia de datos mediante un modelo relacional sólido. |
| **Persistencia / ORM** | JPA + Hibernate | Mapeo de entidades orientadas a objetos y gestión de consultas. |
| **Seguridad** | Spring Security / Filtros de Servidor | Autenticación, control de sesiones y restricción de accesos por Roles (Paciente/Médico). |
---

## Perfiles y Funcionalidades

### 1. Paciente
* **Búsqueda Inteligente:** Filtros geolocalizados por especialidad, profesional y obra social.
* **Gestión de Turnos:** Reserva, cancelación y reprogramación en tiempo real.
* **Historia Clínica Única (HCU):** Acceso a una línea de tiempo unificada de antecedentes y estudios médicos.

### 2. Profesional y Centros de Salud
* **Agenda Médica:** Sincronización automática y bloqueo de horarios.
* **Receta Electrónica:** Emisión de recetas con firma digital y código QR único.
* **Métricas de Gestión:** Dashboards con tasas de ausentismo y volumen de pacientes.

### 3. Administrador
* **Auditoría:** Supervisión global del sistema y resolución de problemas técnicos.
* **Control de Datos:** Gestión de usuarios y mantenimiento preventivo de la plataforma.

---

## Flujo de Funcionamiento
1. **Interacción:** El usuario realiza una acción en el Frontend (React).
2. **Procesamiento:** La solicitud viaja al Backend (Supabase/Node.js) para validación de reglas de negocio.
3. **Persistencia:** Se consulta o actualiza la base de datos PostgreSQL cumpliendo con estándares HL7/FHIR.
4. **Respuesta:** El servidor devuelve la información procesada y la interfaz se actualiza sin recargar la página.

---

## Gestión de Proyecto (PMI)
Este proyecto se rige por los estándares del **PMI (Project Management Institute)** para asegurar la entrega en tiempo y forma.

* **Control de Versiones:** Uso de GitFlow con ramas separadas para funciones (features), desarrollo y producción.
* **Documentación:** Todo el ciclo de vida está registrado en el Plan de Gestión de Proyecto, incluyendo la matriz de responsabilidades y el registro de riesgos.
* **Interoperabilidad:** Implementación mandatoria de encriptación de punta a punta para la protección de datos sensibles.

---

## Roadmap de Desarrollo

### Fase 1: Infraestructura y Persistencia (Entrega del Backend Inicial)
- [ ] Inicialización del entorno Spring Boot (Java 17) y ordenamiento de paquetes físicos en el IDE.
- [ ] Modelado de entidades del ecosistema (`Usuario`, `Paciente`, `Medico`, `Turno`) con anotaciones relacionales JPA.
- [ ] Configuración del motor de persistencia física e Hibernate sobre el esquema MySQL local.
- [ ] Implementación de interfaces de repositorios (`JpaRepository`) para control estricto de transacciones de salud.

### Fase 2: Motor de Servicios y Lógica de Negocio
- [ ] Desarrollo de la capa de servicios y controladores REST para la exposición de endpoints del sistema.
- [ ] Implementación de reglas de control de acceso y seguridad perimetral mediante Spring Security.
- [ ] Módulo inicial de Historia Clínica Única (HCU) y sincronización de agendas profesionales.

### Fase 3: Ecosistema Completo e Interfaz Web
- [ ] Acoplamiento de la interfaz gráfica adaptativa mediante plantillas estáticas (HTML5, CSS3, JavaScript).
- [ ] Receta electrónica interoperable con firma digital y codificación única por código QR.
- [ ] Integración de un directorio geolocalizado de cartilla médica para los habitantes de Cruz del Eje.

---

## Equipo de Desarrollo
* **Martino Costigliolo**
* **Braian Aguilera**
* **Ricardo Cejas**
* **Ana Luz Nieto**
* **Nahuel Aguero**

---

### 🔗 Recursos del Proyecto

* **Repositorio de Código:** [GitHub - Vértice del Olivo](https://github.com/RicardoCejas/Esu)
* **Gestión de Proyectos (PMI):** [Documento PMI del Proyecto](https://docs.google.com/document/d/1EIj0QAYjqWMrMraBL_VO3G_roSU5otVp/edit#heading=h.zbyebere09e)
* **Documentación Técnica:** [Carpeta de Gestión ESU en Google Drive](https://drive.google.com/drive/folders/1Fkj_hzJDNtrR1ZQJit4Ro4zfghxreBYk)
