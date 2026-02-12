package at.spengergasse.spring_thymeleaf.controllers;

import at.spengergasse.spring_thymeleaf.entities.Patient;
import at.spengergasse.spring_thymeleaf.entities.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/patient")
public class PatientController {
    private final PatientRepository patientRepository;
    // mit requestmappping können wir framework sagen gib mir das patient repository,
    // welches du schon erstellt hast, damit ich es hier verwenden kann (dependency injection)
    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/list")
    public String patients(Model model) {
        model.addAttribute("patients", patientRepository.findAll());
        // findall holt alle patienten aus db und gibt als liste zurück

        return "patlist";
    }

    @GetMapping("/add")
    // diese methode macht folgendes: wenn die url
    // mit http://localhost:8080/patient/add aufgerufen wird, dann wird diese methode aufgerufen
    public String addPatient(Model model) {
        model.addAttribute("patient", new Patient());
        return "add_patient";
    }

    @PostMapping("/add")
    public String addPatient(@ModelAttribute("patient") Patient patient) {
        patientRepository.save(patient);
        return  "redirect:/patient/list";
    }
}
