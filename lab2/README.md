# LAB 2


Para executar o server, basta correr o seguinte comando: 

```$ curl -I 127.0.0.1:8080```


Para gerir a aplicação é necessário adicionar pelo menos um *role* ao ficheiro **conf/tomcat-users.xml** 

```
<role rolename="manager-gui"/>
<role rolename="manager-script"/>
<user username="user" password="password" roles="manager-gui, manager-script"/>
```

Pode-se depois aceder à página http://localhost:8080/manager colocando as credenciais definidas em *username* e *password*



## Para criar uma *Web Application* em Maven

```
archetypeGroupId=org.codehaus.mojo.archetypes
archetypeArtifactId=webapp-javaee7
archetypeVersion=1.1

mvn archetype:generate -DgroupId=com.tomcat_21.app -DartifactId=tomcat_webapp -DarchetypeArtifactId=webapp-javaee7 -DarchetypeGroupId=org.codehaus.mojo.archetypes -DarchetypeVersion=1.1 -DinteractiveMode=false
```

Para compilar, e ao contrário dos outros projetos Maven, o comando a utilizar é o seguinte:

```$ mvn install```

O ficheiro *.war* criado é necessário que seja depois colocado na diretoria ***home/joao/apache-tomcat-9.0.54/webapps*** 


O *servlet* adicionado, permite imprimir uma mensagem personalizada, através do *username* passado no endereço *http*. Assim, neste caso, ao aceder ao endereço:
```http://localhost:8080/tomcat_webapp-1.1/app?username=joao``` é impressa uma mensagem personalizada.

Caso não seja passado nenhum utilizador, uma mensagem *Internal Server Error* é mostrada, com uma mensagem personalizada.



## Exercício 2.2
Para correr o projeto usando *web container* de dentro da aplicação, é neceessário adicionar as seguintes dependências no ***pom.xml***
```
<dependency>
    <groupId>org.eclipse.jetty</groupId>
    <artifactId>jetty-server</artifactId>
    <version>9.2.15.v20160210</version>
</dependency>
<dependency>
    <groupId>org.eclipse.jetty</groupId>
    <artifactId>jetty-servlet</artifactId>
    <version>9.2.15.v20160210</version>
</dependency>

```

O projeto Maven deve ser baseado numa aplicação de Java, tal como os primeiros projetos Maven feitos.

## Exercício 2.3
Para criar um projeto *maven-supported, Spring Boot*, é necessário aceder a ```https://start.spring.io/```, caso contrário é possível criar diretamente através do *vscode*. Para correr o projeto é necessário executar um dos seguintes comandos:
```$./mvnwspring-boot:run```
ou
```$ mvninstall -DskipTests && java -jar target\webapp1-0.0.1-SNAPSHOT.jar```


Na alínea b) é pedido para quando se acede ao url definido, aparecer uma mensagem personalizada. Para isso é necessário que na classe *GreetingController.java* se faça return para a página html necessária, no caso *index.html*. Caso no url seja passado o parâmetro ```?name=``` então será impressa uma mensagem com o nome definido, caso contrário, e por defeito, será impressa uma mensagem ```Hello World```.

Na alínea c) a mensagem é impressa em formato JSON, com um id incrementado a cada atualização da página. Também à semelhança do exercício anterior, o nome passado no url é usado. Para isso foi criada a classe *Greeting.java* em que é criado um objeto na classe *GreetingController.java*.

## Exercício 2.4
Exercício muito semelhante ao anterior, mas na classe *GreetingController.java* é necessário mais *@GetMapping*, tendo em conta que vamos ter 3 páginas diferentes.
Apenas de notar que quando o parâmetro é obrigatório é necessário colocar algo assim:
```@RequestParam(value = "show", defaultValue = "0") int id```
mesmo o parâmetro id sendo inteiro, o seu valor por defeito tem que ser passado entre aspas.

Apenas ter em atenção criar as classes necessárias, e criar os arrays que vão servir como forma de guardar os dados. Não é necessário criar *toString()*, o return é feito em formato JSON.


## Questões finais
### **What are the responsibilities/services of a “servlet container”?**
The servlet container provides the servlet easy access to properties of the HTTP request, such as its headers and parameters.
A servlet container performs the following tasks:
1) It creates an instance of the servlet and calls its init() method to initialize it
2) It constructs a request object to pass to the servlet. The request includes, among other things 
    * any HTTP headers from the client
    * parameters and values passed from the client
    * the complete URI of the servlet request
3) It constructs a response object for the servlet.
4) It invokes the servlet service() method.
5) It calls the destroy() method of the servlet to discard it.

### **Explain, in brief, the “dynamics” of Model-View-Controller approach used in Spring Boot to serve web content. (You may exemplify with the context of the previous exercises.)**
Spring Boot uses the *Model-View-Controller* pattern in which application is divided in 3 parts:
1) When an HTTP request is made, the **Controller** receives and processes it.
2) The **Model** works as a middleware between the Controller and the View. This is being controlled by the Controller to update the View. The user is able to see the processed request through the **View**
3) The '@Controller' function handles the requests.

### **Inspect the POM.xml for the previous SpringBoot projects. What is the role of the “starters” dependencies?**
The starters allow us to add jars in the classpath, this makes a much easier and rapid development.    

### **Which annotations are transitively included in the @SpringBootApplication?**
* **@EnableAutoConfiguration**: enable Spring Boot's autoconfiguration mechanisms;
* **@ComponentScan**: enable @ComponentScan on the package where the application is located;
* **@Configuration**: allow to register extra beans in the context or import additional configuration classes.

### **Search online for the topic “Best practices for REST APIdesign”. From what you could learn, select your “top 5”practices,and briefly explain them in you own words.**

1) **Accept and respond with JSON** - Rest Api's should accept and send responses in JSON format. Almost every networked technology uses built-in methods to handle with JSON, what simplifies all work.

2) **Cache data to improve performance** - In order to get data faster, caching is a good solution. Using this method it isn't necessary to query database everytime we need information. However, the data that users get may be outdated.

3) **Maintain good security practices** - For exemple, to save passwords, thet should be encrypted.

4) **Allow filtering, sorting, and pagination** - Sometimes, there is too much data that shouldn't be returned all at once beecause it can slow or bring the system down. Filtering and pagination both increase performance by reducing the usage of server resources.

5) **Use Status Codes in Error Handling** - Use regular HTTP status codes in responses to requests made. This will help users to know what is going on – whether the request is successful, or if it fails.

