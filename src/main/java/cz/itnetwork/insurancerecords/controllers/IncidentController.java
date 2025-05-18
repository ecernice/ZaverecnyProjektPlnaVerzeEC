package cz.itnetwork.insurancerecords.controllers;

import cz.itnetwork.insurancerecords.models.dto.IncidentDTO;
import cz.itnetwork.insurancerecords.models.dto.InsuranceDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/database/incidents")
public class IncidentController {

    @GetMapping
    public String renderIndex() {

        return "pages/database/incidents/index";
    }

    @GetMapping ("/create")
    public String renderCreateForm(@ModelAttribute IncidentDTO incident) {
        System.out.println("Zobrazuji formulář pro novou pojistnou událost");
        return "pages/database/incidents/create";
    }

    @GetMapping ("/detail")
    public String renderDetail() {

        return "pages/database/incidents/detail";
    }

    @GetMapping ("/edit")
    public String renderEdit() {

        return "pages/database/incidents/edit";
    }

    @PostMapping("create")
    public String createIncident(
            @Valid @ModelAttribute IncidentDTO incident,
            BindingResult result
    ) {
        if (result.hasErrors()){
            System.out.println("Formulář obsahuje chyby:" + result.getAllErrors());
            return renderCreateForm(incident);}

        // Zde budeme později pracovat s databází
        System.out.println(incident.getTitle() + " – " + incident.getIncidentDate());

        return "redirect:/incidents";
    }

}
