# Spring-Boot-application-ABML
API RESTful de gestión de clientes, productos y ventas. Es el proyecto final del curso de TodoCode Academy
donde utilizamos Java y Spring Boot con base de datos MySQL. La API permite realizar operaciones CRUD para las entidades "Cliente",
"Producto" y "Venta".
* Al realizar una venta asociaremos a un cliente, y una lista de productos. Cada vez que se realize una venta se descontara la cantidad de los productos
en la base de datos.

# Tecnologias utilizadas:
* Java 17
* Spring Boot 3.2.0
* Base de datos MySQL
* Swagger

# Instalación
Para instalar, crea una base de datos llamada "product_bd", luego clona el repositorio, importa el proyecto a tu IDE de preferencia
y ejecuta mvn spring-boot:run desde la línea de comandos.

Con la aplicación ejecutada ingresa a localhost:8080/doc/swagger-ui.html para ver la documentación de la API, sus endpoints y más información.
Puedes realizar pruebas con POSTMAN.
