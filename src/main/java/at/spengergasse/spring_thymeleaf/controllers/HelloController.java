package at.spengergasse.spring_thymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class HelloController {
// automatisch geladen, keine abhängigkeiten
    // getmapping ruft die methode index auf,
// wenn die url mit http://localhost:8080/ aufgerufen wird
    @GetMapping("")
    public  String index(Model model) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        model.addAttribute("today", LocalDate.now().format(dtf));
        // wenn leerer string eingegeben wird, kommt methode index, welche das
        // aktuelle datum formatiert und an die view weitergibt
        return "index";
    }
}
