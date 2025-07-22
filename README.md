
# 📦 Prueba Técnica Backend Jr.

Este proyecto es una API RESTful desarrollada como parte de una prueba técnica para la posición Backend Jr.  
El objetivo es gestionar usuarios y productos, implementando registro, login, recuperación de contraseña y CRUD de productos.

## 🚀 Tecnologías utilizadas
- Java 21
- Spring Boot
- Spring Security (JWT)
- Hibernate / JPA
- MySQL (o PostgreSQL)
- Maven

## ⚙️ Funcionalidades principales
- Registro de usuarios
- Login de usuarios
- Recuperación de contraseña
- Operaciones CRUD de productos (crear, leer, actualizar, eliminar)
- Seguridad con autenticación mediante JWT

---

## ⚙️ Requisitos previos

- [Java 21 JDK](https://jdk.java.net/21/)
- [Maven 3.8+](https://maven.apache.org/)
- Git (opcional, para clonar el repositorio)

---

## 🚀 Cómo ejecutar el proyecto localmente

1. **Clona el repositorio**
```bash
git clone https://github.com/Jseba-s/RepositoryPrueba.git
Ingresa a la carpeta del proyecto

bash
Copiar
Editar
cd RepositoryPrueba
Construye el proyecto con Maven

bash
Copiar
Editar
mvn clean install
Ejecuta el proyecto

bash
Copiar
Editar
mvn spring-boot:run
🌐 Endpoints principales
GET /api/materiales – Listar materiales

POST /api/materiales – Crear material

GET /api/proveedores – Listar proveedores

POST /api/proveedores – Crear proveedor

GET /api/categorias – Listar categorías

POST /api/categorias – Crear categoría

(Puedes verlos y probarlos usando Postman o Swagger si está configurado)

📁 Estructura del proyecto
plaintext
Copiar
Editar
src/
├── main/
│   ├── java/
│   │   └── com/ejemplo/proyecto
│   │       ├── controller
│   │       ├── model
│   │       ├── repository
│   │       └── service
│   └── resources/
│       ├── application.properties
│       └── data.sql (opcional)
└── test/ (tests unitarios)
🛡️ Notas adicionales
Verifica que tu JAVA_HOME apunte a Java 21.

Puedes usar application.properties o application.yml para configurar la base de datos y puerto.

Si tienes dudas o quieres mejorar el proyecto, eres bienvenido a hacer un pull request.

✍️ Autor
Jseba-s
