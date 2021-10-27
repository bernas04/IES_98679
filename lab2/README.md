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