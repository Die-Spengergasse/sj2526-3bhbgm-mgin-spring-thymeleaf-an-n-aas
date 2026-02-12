package at.spengergasse.spring_thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringThymeleafApplication.class, args);
    }


    /*
    * spring application macht automatisch
    * webserver auf port 8080 starten
    * sucht alle klassen die von ding sind eine instanz und verknüpft diese
    * spring boot starter web: spring-boot-starter-web
    * findet dabei nur jene klassen die im selben package oder in einem unterpackage liegen
    * sucht alle klassen mit spezifischen annotationen (z.b. @Controller, @Service, @Repository) und erstellt instanzen davon
    * baut diese ein in das gesamtsystem (dependency injection)
    *
    * was ist eine spring boot application? --> eine klasse mit der annotation @SpringBootApplication
    *
    *
    * */
}
