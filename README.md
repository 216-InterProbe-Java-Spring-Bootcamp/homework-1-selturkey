# first-homework
216-InterProbe-Java-Spring-Bootcamp First Homework
Start to Project




Exploring The Stracture
==================

1. The "Swagger" lives in the `http://localhost:8080/swagger-ui/index.html#`.

   ### Folder and File Stracture

```
comments (users and products have same folder and file structure)
│   
└───controller
|    └───rest
|         └───CommentsRestController.java (allows to handle all REST APIs such as GET, POST, Delete, PUT requests.)
|
└───converter(Mapper to Convert Dto and Entities to eachothers by Mapstruct)
|    └───CommentMapper.java
|   
└───dao(Data Access Object)
|    └───CommentDao.java
|
└───dto(Data Transfer Object)(used to pass data with multiple attributes in one shot from client to server, to avoid multiple calls to a remote server)
|    └───CommentResponseDto.java
|    └───CommentSaveRequestDto.java
|    └───CommentUpdateRequestDto.java
|
└───entity
|    └───Comments.java (the persistence objects stores as a record in the database)
|
└───service
|    └───CommentsService.java(Communication between the controller and the persistence layer)
|    └───entityservice
|         └───CommentEntityService.java (Extends from  Generic BaseEntityService)
|       
|   ...
│
└───generic
│    └───entity
|    |    └───BaseEntity.java
|    |    └───BaseModel.java
|    |    └───BaseAdditionalFields.java
|    └───exceptions
|    |    └───RecordNotFoundException.java
|    └───response
|    |    └───RestResponse.java
|    └───service
|         └───BaseEntityService.java    
│       ...

Homework1Aplication.java

```
2. Database Connection Configuration.
    ### application.properties Configure Your Database

```
spring.datasource.url=jdbc:postgresql://localhost:5432/homework1
spring.datasource.username=dbuser
spring.datasource.password=123456
spring.datasource.driver-class-name=org.postgresql.Driver
```


3. Mapper MapStruct
   ### pom.xml add  mapstruct dependency
```
    <properties>
        <org.mapstruct.version>1.5.2.Final</org.mapstruct.version>
    </properties>
    
        <dependency>
            <groupId>org.mapstruct</groupId>
            <artifactId>mapstruct</artifactId>
            <version>${org.mapstruct.version}</version>
        </dependency>
        <dependency>
            <groupId>org.mapstruct</groupId>
            <artifactId>mapstruct-processor</artifactId>
            <version>${org.mapstruct.version}</version>
        </dependency>
        
```

4. Fake Data JavaFaker
    ### pom.xml add javafaker dependency
```
        <dependency>
            <groupId>com.github.javafaker</groupId>
            <artifactId>javafaker</artifactId>
            <version>0.15</version>
        </dependency>
```

# Entities Created Extends from Generic BaseEntity Abstract Class
## Entity Relationship Diagram
![Entity Diagram](/Docs/ScreenShots/EntityRelationshipDiagram.png)

## Spring Boot Data Process Flow

![DataProcessFlow](/Docs/ScreenShots/dataProcessflow.png)


