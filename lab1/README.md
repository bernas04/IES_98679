# Lab1 Notebook

## Lab1_2

**src/main/java** código fonte
**src/test/java** fonte de teste
**pom.xml** ficheiro com a configuração do projeto em Maven

*mvn clean dependency:copy-dependencies package*  This command will clean the project, copy dependencies, and package the project

**groupId** identifica de forma única cada projeto. O *groupId* segue as regras do nome das packages java, iniciando-se de forma inversa. (Ex: com.apple.quicktime.v2) 
**artifactId** nome do JAR sem a versão. Se for criado, pode ser escolhido um nome arbitrário em letras minúsculas e sem caracteres não alfanuméricos. Se o JAR for de partilhado, então deve-se usar o *artifactID* partilhado.
**version** podem ser usados JAR's diferentes

**archetype maven** cria estruturas automaticamente. Em Maven, cria o ficheiro *pom.xml*, juntamente com a pasta *src* e as respetivas subpastas.

No ficheiro *pom.xml* é possível adicionar informação extra acerca.


mvn exec:Java -exec:mainClass="----" -D exec:cleanupDaemonThreads=false


### Compilar e executar o projeto *maven*

Para compilar o projeto *maven* é apenas necessário executar o comando ```mvn package``` dentro da diretoria do projeto.
Por outro lado, para executar é necessário executar o comando ```mvn exec:java -Dexec.mainClass="weather.WeatherStarter```
De notar que para executar, foi necessário mover o ficheiro *WeatherStarter* para a diretoria ```my_weather_radar/src/main/java/```, enquanto que o resto dos ficheiros mantiveram-se na diretoria ```my_weather_radar/src/main/java/com/ies/weather/```


### Passar argumentos através da linha de comandos

```mvn exec:java -Dexec.mainClass="main_class_here" -Dexec.args="arg0 arg1 arg2"```

