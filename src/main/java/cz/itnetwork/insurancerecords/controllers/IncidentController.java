package cz.itnetwork.insurancerecords.controllers;

import cz.itnetwork.insurancerecords.models.dto.IncidentDTO;
import cz.itnetwork.insurancerecords.models.dto.InsuranceDTO;
import cz.itnetwork.insurancerecords.models.services.IncidentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping ("/database/incidents")
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    @GetMapping
    public String renderIndex(Model model) {
        List<IncidentDTO> incidents = incidentService.getAll();
        model.addAttribute("incidents", incidents);

        return "pages/database/incidents/index";
    }

    @GetMapping ("/create")
        public String renderCreateForm(@ModelAttribute IncidentDTO incident) {
        System.out.println("Zobrazuji formulář pro novou pojistnou událost");
        return "pages/database/incidents/create";
    }

    @GetMapping ("{incidentId}")
    public String renderDetail(
            @PathVariable long incidentId,
            Model model
    ) {
        IncidentDTO incident = Optional.ofNullable(incidentService.getById(incidentId))
                        .orElse(new IncidentDTO());
        model.addAttribute("incident", incident);
        System.out.println("Zobrazuji detail pojistné události");

        return "pages/database/incidents/detail";
    }

    @GetMapping ("/edit")
    public String renderEdit() {

        return "pages/database/incidents/edit";
    }

    @PostMapping("/create")
    public String createIncident(
            @Valid @ModelAttribute IncidentDTO incident,
            BindingResult result
    ) {
        if (result.hasErrors()){
            System.out.println("Formulář obsahuje chyby:" + result.getAllErrors());
            return renderCreateForm(incident);}

        IncidentDTO savedIncident = incidentService.create(incident);

        return "redirect:/database/incidents/" + savedIncident.getIncidentId();
    }

}
