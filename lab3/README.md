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



1. Get a list with employees:
* Method: GET
* End Point: `http://localhost:8080/employees`
* Method: POST
* Method: DELET
* Method: PUT

