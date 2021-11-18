# LAB 3
## Exercício 1
## Alínea b
### **The “UserController” class gets an instance of “userRepository” through its constructor; how is this new repository instantiated?**
The UserRepository is initialized because UserController has the @Autowired annotation, which injects an instance of UserRepository on the UserController object.

### **List the methods invoked in the “userRepository” object by the “UserController”. Where are these methods defined?**
The methods called are findAll(), save(), findById() and delete(). These are defined on the CrudRepository class, which our Repository extends.

### **Where is the databeing saved?**
The data is being saved using the h2database, which we added to the project as a dependency. By default, it is an in-memory database.

### **Where is the rule for the “not empty” email address defined?**
The "not empty" rule is defined on the User class, with the annotation @NotBlank, used when we declare the attribute.


## Exercício 2



1. Get a list with all employees:
* Method: GET
* End Point: `http://localhost:8080/api/v1/employees`
2. Insert employee
* Method: POST
* End Point: `http://localhost:8080/api/v1/employees`
3. Delete an employee
* Method: DELET
* End Point: `http://localhost:8080/api/v1/employees/{id}`
4. Update an employee
* Method: UPDATE
* End Point: `http://localhost:8080/api/v1/employees/{id}`

5. Get Employee by ID
* Method: GET
* End Point: `http://localhost:8080/api/v1/employees/{id}`

The simplest way to create a spring project is to use Spring Initializr, which is an online Spring Boot application generator.
After this step, it is highly recommended to create 4 repositories (**controller**, **exception**, **model**, **repository**).

### Exception
Spring Boot provides a good default implementation for exception handling for RESTful Services. 
we can specify the Response Status for a specific exception along with the definition of the Exception with **@ResponseStatus** annotation.

Default error response provided by Spring Boot contains all the details that are typically needed.
However, it is possible to create a framework independent response structure for thr organization. In that case, we can define a specific error response structure.

To use ErrorDetails to return the error response, let’s create a `GlobalExceptionHandler` class annotated with `@ControllerAdvice` annotation. This class handles exception-specific and global exceptions in a single place.


### Run application

This spring boot application has an entry point Java class called `SpringBootCrudRestApplication.java` with the **public static void main(String[] args)** method, which we can run to start the application.

`@SpringBootApplication` is a convenience annotation that adds all of the following:

* `@Configuration` tags the class as a source of bean definitions for the application context.
* `@EnableAutoConfiguration` tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
* Normally you would add `@EnableWebMvc` for a Spring MVC app, but Spring Boot adds it automatically when it sees spring-webmvc on the classpath. This flags the application as a web application and activates key behaviors such as setting up a DispatcherServlet.
* `@ComponentScan` tells Spring to look for other components, configurations, and services in the hello package, allowing it to find the controllers.
The main() method uses Spring Boot’s SpringApplication.run() method to launch an application.

## Exercício 3

In this exercise, we have to implement something like we did in exercise 2.

We are going to use three-layer architecture in our Spring boot project:

1. **Presentation layer/API Layer** This is the user interface of the application that presents the application’s features and data to the user.

2. **Business/Service layer** This layer contains the business logic that drives the application’s core functionalities. Like making decisions, calculations, evaluations, and processing the data passing between the other two layers.

3. **Data access object (DAO) layer** This layer is responsible for interacting with databases to save and restore application data.

First we need to create a Spring Boot project, just like we did in the previous exercise (don't forget to update *POM* file like in the exemple here: `https://www.sourcecodeexamples.net/2021/08/spring-boot-project-with-controller.html`)

We have Movies and Quotes classes, so it is necessary to create *Controller*, *Repository*, *Service* for each. Beyond this, as we have a separation between this two classes, it is necessary to create another class which will join these two classes.


## Review questions

**a) Explain the differences between the RestController and Controller components used in different parts of this lab.**
The `@Controller` is used to mark a class as Spring MVC Controller. `@RestController` annotation is applied to a class to mark it as a request handler, and Spring will do the building and provide the RESTful web service at runtime, it is equivalent of `@Controller` and `@ResponseBody` togheter.

We don't need to use @Controller and @RestponseBody annotation, instead you can use @RestController to provide the same functionality. In short, it is a convenience controller that combines the behavior of @Controler and @Response body into one.

The `@Controller` is a specialization of `@Component` annotation while `@RestController` is a specialization of `@Controller` annotation.

**C) Explain the annotations @Table, @Colum, @Id foundin the Employee entity.**
* **@Table** each entity class maps a database table with the same name in the default schema of your database. We can customize this mapping using the name, schema, and catalog attributes of the @Table annotation.

* **@Column** optional annotation that enables us to customize the mapping between the attribute and the database column.

* **@Id** JPA requires to specify one primay key attribute for each entity. To to this, we can annotating an attribute with @Id 

**d) Explain the use of the annotation @AutoWired (in the Rest Controller class).**
The Spring framework enables automatic dependency injection. So, by declaring all the bean dependencies in a Spring configuration file, Spring container can autowire relationships between collaborating beans. This is called Spring bean autowiring