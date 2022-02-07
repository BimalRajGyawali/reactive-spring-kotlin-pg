## Reactive Spring with Kotlin and Pg

- Spring WebFlux with Netty instead of Spring Web with Tomcat

- Mono and Flux in all layers (controller, service, repo)

- JDBC/JPA/Hibernate, Spring Data JDBC (javax.persistence) are non-reactive and hence not used for reactive approach

- Two alternatives : 1. Spring Data R2DBC  and  2. Reactive Hibernate


### Spring Data R2DBC

- Instead R2DBC(Reactive Relational Database Connectivity) and Spring Data R2DBC is used

- No automatic table generation in R2DBC and less mature/ less features than JPA/Hibernate so flyway or liquibase are used for schema generation

- Spring Data R2DBC provides ReactiveCrudRepository interface

- `org.springframework.data.relational.core.mapping.Table` is used to indicate that a given class represents a table (does not create table in db, only representation )instead of javax.persistence.Table

<br>

`repo`

```Java  
interface UserCredentialsRepo : ReactiveCrudRepository<UserCredentials, Int>
```


`application.properties`

```
spring.r2dbc.url=r2dbc:postgresql://localhost:5432/test
spring.r2dbc.username=postgres
spring.r2dbc.password=postgres
spring.data.r2dbc.repositories.enabled=true
```

`pom.xml`

```xml
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-data-r2dbc</artifactId>
</dependency>


<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-webflux</artifactId>
</dependency>


<dependency>
   <groupId>io.r2dbc</groupId>
   <artifactId>r2dbc-postgresql</artifactId>
   <scope>runtime</scope>
</dependency>

```

<br>

**Limitations of Spring Data R2DBC** :

- doesn't deal with the relationship between entities itself . We will have to find a solution and do something manually 

- no support for auto-generated id
<br>

Spring Data R2DBC aims at being conceptually easy. In order to achieve this it does NOT offer caching, lazy loading, write behind or many other features of ORM frameworks. This makes Spring Data R2DBC a simple, limited, opinionated object mapper.



 Spring Data R2DBC Not fully ready for every production project .
- Projects without high concurrency issues don't need to use it
- Some useful functions have not yet been realized （ For example, improving relationship management ).
But they're in the team roadmap , Even if a clear release date has not yet been defined .Spring The team fully understands the needs of the developers , And working on it .
 
 
For all that , in some special cases , if the development team is ready to do more manual work , what is worth considering is R2DBC performance improvements.
 
 
References :<br>
[https://javamana.com/2021/01/20210120001209100Y.html](https://javamana.com/2021/01/20210120001209100Y.html)<br>
[https://github.com/spring-projects/spring-data-r2dbc](https://github.com/spring-projects/spring-data-r2dbc)<br>
[https://dzone.com/articles/you-dont-need-hibernate-with-spring-webflux-and-r2](https://dzone.com/articles/you-dont-need-hibernate-with-spring-webflux-and-r2)<br>
 
 
 <br>
 
## 2. Hibernate Reactive

- Hibernate started a subproject — Hibernate Reactive for Reactive Streams support

- Spring still did not embrace Hibernate Reactive

- We should deal with internals of Hibernate like SessionFactory, CriteriaBuilder, etc.

 - The reactive stream is represented using a chain of Java CompletionStages or Mutiny Unis and Multis ( alternatives of Mono and Flux )

 - Hibernate Reactive uses the reactive engine Vert.x and its non-blocking SQL client libraries (not R2DBC). 

<br>

References : <br>
[https://www.i-programmer.info/news/80-java/15025-hibernate-goes-reactive-but-what-does-that-mean.html](https://www.i-programmer.info/news/80-java/15025-hibernate-goes-reactive-but-what-does-that-mean.html)

