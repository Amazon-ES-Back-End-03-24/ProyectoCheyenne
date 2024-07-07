# Inventory Tool

## Descripción del proyecto

Este proyecto es una herramienta de inventario desarrollada para gestionar productos, clientes, y listas de deseos. Proporciona funcionalidades como la adición y eliminación de productos a listas de deseos, autenticación de usuarios, y más. Está construido utilizando tecnologías modernas y buenas prácticas de desarrollo para asegurar un rendimiento óptimo y una fácil mantenibilidad.

## Diagrama de Clases



## Configuración

Para configurar y ejecutar este proyecto, sigue estos pasos:



2. Navega al directorio del proyecto:
    ```sh
    cd inventory-tool
    ```

3. Configura tu base de datos en `application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/inventory_db
    spring.datasource.username=root	
    spring.datasource.password=password
    ```

4. Ejecuta el proyecto utilizando Maven:
    ```sh
    mvn spring-boot:run
    ```

## Tecnologías utilizadas

- Java 21.0.2
- Spring Boot 3.3.0
- MySQL
- JPA/Hibernate
- Lombok
- Postman (para pruebas de API)

## Estructura de controladores y rutas

- **AuthController**: Maneja la autenticación y autorización de usuarios.
  - `POST /api/login`: Iniciar sesión.

- **WishListController**: Maneja las listas de deseos de los clientes.
  - `POST /wishlist/add`: Añadir producto a la lista de deseos.
  - `DELETE /wishlist/remove`: Eliminar producto de la lista de deseos.
  - `GET /wishlist`: Obtener todas las listas de deseos.
  - `GET /wishlist/{customerId}`: Obtener la lista de deseos de un cliente por ID.



## Enlaces adicionales
https://slides.com/cheyennesaiz/bento/scroll#/our-services

## Trabajo futuro

Me gustaría seguir capacitándome en desarrollo de software. Mis próximos objetivos son aprender Python y seguir adquiriendo conocimientos avanzados en Java. 

## Recursos

- Profesora Lisa
- ChatGPT
- Student Portal
- YouTube
- GitHub

## Miembros del equipo

- Cheyenne Saiz Aguado
-Andres
-Marco
-Miguel Angel
-Adrian
-Lourdes
-Fran
-Mohammed
-Isaac
-Raul
-Laura
-Lisa


---
