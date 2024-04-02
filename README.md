### Project Purpose
- This project was build to be part of my personal portfolio. 
- It is just a sample code that is not intended to be used in production.
- This Spring Boot application provides a REST API for an oversimplified ecommerce website without integration with payment or delivery methods.
- It includes CRUD operations for Product, Category, User, PurchaseOrder and PurchaseOrderLine entities. It also includes a simple authentication mechanism using JWT.
- The idea is that is the exposes the same API as in https://github.com/ahierro/simple-online-store-java but made in Kotlin instead of Java and some other slight differences like using Flyway instead of Liquibase, MySQL instead of PostgreSQL and Spring Web instead of WebFlux.

### Technologies used for this project
* Kotlin
* Spring Boot 3.2.3
* Spring Web
* Spring Boot Docker Compose Support
* Spring Security
* Flyway
* MySQL
* Spring Data (including queries with pagination and sorting)
* Test Containers
* Swagger
* JWT authentication
* Junit
* Gradle

### Swagger documentation can be found at http://localhost:8080/swagger-ui.html
![swagger](/swagger-ui.jpg "Swagger")

### Local MySql instance is started automatically when running the application locally and the configuration is loaded from compose.yaml
- In case you don't want to run docker compose automatically set
```properties
spring.docker.compose.enabled=false
```
and run the following command
```shell
docker run --detach --name mysql --env MYSQL_USER=myuser --env MYSQL_DATABASE=mydatabase --env MYSQL_PASSWORD=secret --env MYSQL_ROOT_PASSWORD=verysecret --volume mysql:/var/lib/mysql --publish 3306:3306 mysql
```
### Postman collection file
simple-online-store-kotlin.postman_collection.json

### Start Application
```shell
./gradlew bootRun
``` 
