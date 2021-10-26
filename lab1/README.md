# Lab1 Notebook

## Lab1_2

**src/main/java** código fonte
**src/test/java** fonte de teste
**pom.xml** ficheiro com a configuração do projeto Maven

*mvn clean dependency:copy-dependencies package*  This command will clean the project, copy dependencies, and package the project

**groupId** identifica de forma única cada projeto. O *groupId* segue as regras do nome das packages java, iniciando-se de forma inversa. (Ex: com.apple.quicktime.v2) 
**artifactId** nome do JAR sem a versão. Se for criado, pode ser escolhido um nome arbitrário em letras minúsculas e sem caracteres não alfanuméricos. Se o JAR for de partilhado, então deve-se usar o *artifactID* partilhado.
**version** podem ser usados JAR's diferentes

**archetype maven** cria estruturas automaticamente. Cria o ficheiro *pom.xml*, juntamente com a pasta *src* e as respetivas subpastas.

No ficheiro *pom.xml* é possível adicionar informação extra acerca.


```mvn exec:java -Dexec.mainClass="main_class_here"```


### Compilar e executar o projeto *maven*

Para compilar o projeto *maven* é apenas necessário executar o comando ```mvn package``` dentro da diretoria do projeto.
Por outro lado, para executar é necessário executar o comando ```mvn exec:java -Dexec.mainClass="weather.WeatherStarter```
De notar que para executar, foi necessário mover o ficheiro *WeatherStarter* para a diretoria ```my_weather_radar/src/main/java/```, enquanto que o resto dos ficheiros mantiveram-se na diretoria ```my_weather_radar/src/main/java/com/ies/weather/```


### Passar argumentos através da linha de comandos

```mvn exec:java -Dexec.mainClass="main_class_here" -Dexec.args="arg0 arg1 arg2"```

## Git

### Fluxo de trabalho Git:
 
 ```
 $ cd IES_98679                                             # move to the root of the working folder to be imported
 $ git init                                                 # initialize a local git repo in this folder 
 $ git remote add origin hhtp://www.github.com/bernas04     #must adapt the url for your repo 
 $ git add.                                                 # mark all existing changes in this root to be commited 
 $ git commit -m "Initial project setup for exercise 1_3"   #create the commit snapshot locally 
 $ git push -u origin main                                  #uploads the local commit to the shared repo 
   ```

Todos os ficheiros, pastas, etc especificados no ficheiro *.gitignore* não serão enviados para o repositório remoto. Todos os ficheiros que correspondam a versões compiladas de programas, ficheiros indesejados, podem desta maneira serem ignorados. 

## Docker

Para verificar a versão atual do Docker pode ser utilizado o seguinte comando: 
```
docker --version
```

Para ver a lista de *containers* Docker: 
``` docker ps -a ```

Para parar um *container*:
``` docker stop [container_id] ```

#### Run your image as a container

Run the following command to start a container based on your new image:

```  docker run --publish 8000:8080 --detach --name bb bulletinboard:1.0 ```

There are a couple of common flags here:

* --publish asks Docker to forward traffic incoming on the host’s port 8000 to the container’s port 8080. Containers have their own private set of ports, so if you want to reach one from the network, you have to forward traffic to it in this way. Otherwise, firewall rules will prevent all network traffic from reaching your container, as a default security posture.
* --detach asks Docker to run this container in the background.
* --name specifies a name with which you can refer to your container in subsequent commands, in this case bb.
Visit your application in a browser at localhost:8000

Once you’re satisfied that your bulletin board container works correctly, you can delete it:

```$ docker rm --force bb```

The **--force** option stops a running container, so it can be removed. If you stop the container running with docker stop bb first, then you do not need to use **--force** to remove it.

### Dockerize PostgreSQL

Build an image from the Dockerfile and assign it a name:

```$ docker build -t eg_postgresql .```
Run the PostgreSQL server container (in the foreground):

```$ docker run --rm -P --name pg_test eg_postgresql```
Connect from your host system:

```$ docker ps```
Connect to the database:

```$ sql -h localhost -p 49153 -d docker -U docker --password```


### Docker compose

To start docker-compose use:

```$ docker-compose up```
To stop docker-compose:

```$ docker-compose stop```



## Exercício 1.5
Para fazer este exercício, comecei por criar dois projetos *maven*, separando desta forma a interação do utilizador (*user*), da API(*weather*).  
Do lado do utilizador, foi necessário adicionar mais uma dependência no ficheiro *pom.xml* (para além das dependências anteriores).
```<dependency>
      <groupId>com.weather.app</groupId>
      <artifactId>weather</artifactId>
      <version>1.0-SNAPSHOT</version>
    </dependency> 
```
Esta dependência refere-se ao outro projeto *maven*. Neste projeto adicionei a classe *WeatherStarter*.

Quanto à API, comecei por adicionar as classes Java ao projeto *weather* (CityForecast.java, IpmaCityForecast.java, IpmaService.java), executando de seguida o seguinte comando: 
```
mvn package
```
Após este passo, na pasta do projeto *user* executei o comando: 
```
mvn install:install-file -Dfile="/home/joao/Desktop/Universidade/3ano/IES_98679/lab1/lab1_5/weather/target/weather-1.0-SNAPSHOT.jar"  -DgroupId="com.weather.app" -DartifactId="weather" -Dversion="1.0-SNAPSHOT" -Dpackaging=jar
```
Este comando é utilizado para criar *.jar artifacts* que serão enviados para a diretoria especificada em **-Dfile=" "**. Cria-se, assim, uma espécie de "ponte" entre os dois projetos.

Por fim, já é possível compilar e executar o projeto *maven user*. Para executar utilizamos a seguinte linha: 
```
mvn exec:java -Dexec.mainClass="com.user.app.WeatherStarter" -Dexec.args="14234" -Dexec.cleanupDaemonThreads=false
```




## Resposta às perguntas finais
### Alínea a)
Default lifecycle has a lot of phases (**23**):
* **validate**	validate if the project is correct and if all necessary information is available.
* **initialize**	initialize build state, e.g. set properties or create directories.
* **generate-sources**	generate any source code for inclusion in compilation.
* **process-sources**	process the source code, for example to filter any values.
* **generate-resources**	generate resources for inclusion in the package.
* **process-resources**	copy and process the resources into the destination directory, ready for packaging.
* **compile**	compile the source code of the project.
* **process-classes**	post-process the generated files from compilation.
* **generate-test-sources**	generate any test source code for inclusion in compilation.
* **process-test-sources**	process the test source code.
* **generate-test-resources**	create resources for testing.
* **process-test-resources**	copy and process the resources into the test destination directory.
* **test-compile**	compile the test source code into the test destination directory
* **process-test-classes**	post-process the generated files from test compilation.
* **test**	run tests using a suitable unit testing framework. These tests should not require the code be packaged or deployed.
* **prepare-package**	perform any operations necessary to prepare a package before the actual packaging. This often results in an unpacked, processed version of the package.
* **package**	take the compiled code and package it in its distributable format, such as a JAR.
* **pre-integration-test**	perform actions required before integration tests are executed. This may involve things such as setting up the required environment.
* **integration-test**	process and deploy the package if necessary into an environment where integration tests can be run.
* **post-integration-test**	perform actions required after integration tests have been executed. This may including cleaning up the environment.
* **verify**	run any checks to verify the package is valid and meets quality criteria.
* **install**	install the package into the local repository, for use as a dependency in other projects locally.
* **deploy**	done in an integration or release environment, copies the final package to the remote repository for sharing with other developers and projects.

### Alínea b)
Maven main purpose is to configure a project and handle the build activities and resulting artifacts. Maven can activate different plugins, including plugins to execute a specific class.

### Alínea c)
* git pull - get the latest project version
* git add . - add all changes that had been made, since last modification.
* git commit -m "*some message here*" - explain the modifications made by the user.
* git push - used to upload local repository content to a remote repository.


### Alínea d)
To write good commit messages, people should include information like:
* Describe why a change is being made
* How does it address the issue?
* What effects does the patch have?
* Do not assume the reviewer understands what the original problem was.
* Do not assume the code is self-evident self-documenting.
* Read the commit message to see if it hints at improved code structure.
* Describe any limitations of the current code.
* Do not include patch set-specific comments.

other important thing is the commit message. This should fulfill some rules:
* Separate subject from body with a blank line
* Do not end the subject line with a period
* Capitalize the subject line and each paragraph
* Use the imperative mood in the subject line
* Wrap lines at 72 characters
* Use the body to explain what and why you have done something. In most cases, you can leave out details about how a change has been made.

### Alínea e)

Explicating dedicate resources makes data safer (from container deletion) and easier to backup production databases.
