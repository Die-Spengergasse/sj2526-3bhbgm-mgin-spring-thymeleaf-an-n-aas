package at.spengergasse.spring_thymeleaf.controllers;

import at.spengergasse.spring_thymeleaf.entities.Haustier;
import at.spengergasse.spring_thymeleaf.entities.HaustierRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/haustier")
public class HaustierController {
    // hier brauchen wir das haustier repository, damit wir auf die datenbank zugreifen können
private final HaustierRepository haustierRepository;

// hier geben wir dem controller das haustier repository, damit er es verwenden kann,
// um auf die datenbank zuzugreifen (dependency injection)

    public HaustierController(HaustierRepository haustierRepository) {
        this.haustierRepository = haustierRepository;
    }
    // getmapping ruft die methode haustiere auf,
    // wenn die url mit http://localhost:8080/haustier/list aufgerufen wird
    @GetMapping("/list")
    public String haustiere(Model model) {
        model.addAttribute("haustieres", haustierRepository.findAll());
        return "haustier_list";
    }

    // add mapping ruft die methode addHaustier auf
    @GetMapping("/add")
    public String addHaustier(Model model) {
        model.addAttribute("haustier", new Haustier());
        return "add_haustier";
    }
    // postmapping macht dasselbe wie addmapping, aber es wird aufgerufen,
    // wenn die form auf der add_haustier seite abgeschickt wird,
    // um das neue haustier zu speichern
    @PostMapping("/add")
    public String addHaustier(@ModelAttribute("haustier") Haustier haustier) {
        haustierRepository.save(haustier);
        return "redirect:/haustier/list";
    }
    //Haustier löschen
    @GetMapping("/delete/{id}")
    public String deleteHaustier(@PathVariable int id) {
        haustierRepository.deleteById(id);
        return "redirect:/haustier/list";
    }

    // bearbeiten eines haustiers: getmapping zeigt die form mit den aktuellen daten an,
    @GetMapping("/edit/{id}")
    public String editHaustierForm(@PathVariable int id, Model model) {
        Haustier haustier = haustierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Haustier nicht gefunden"));
        model.addAttribute("haustier", haustier);
        return "edit_haustier";
    }

    // aktualisieren der Daten in der Datenbank und speichern
    @PostMapping("/edit/{id}")
    public String editHaustier(@PathVariable int id,
                               @ModelAttribute("haustier") Haustier haustier) {
        haustier.setId(id); // ID muss gesetzt bleiben, sonst legt JPA neues Objekt an!
        haustierRepository.save(haustier);
        return "redirect:/haustier/list";
    }
}
