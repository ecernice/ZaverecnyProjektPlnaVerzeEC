package cz.itnetwork.insurancerecords.controllers;

import cz.itnetwork.insurancerecords.models.dto.IncidentDTO;
import cz.itnetwork.insurancerecords.models.dto.mappers.IncidentMapper;
import cz.itnetwork.insurancerecords.models.services.IncidentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

/**
 * Controller for managing insurance incidents.
 * Provides endpoints for listing, viewing details, creating, editing, and deleting incidents.
 */
@Controller
@RequestMapping ("/database/incidents")
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    @Autowired
    private IncidentMapper incidentMapper;

    /**
     * Displays a list of all insurance incidents.
     *
     * @param model Model for passing data to the view.
     * @return Name of the view template for the list.
     */
    @GetMapping
    public String renderIndex(Model model) {
        List<IncidentDTO> incidents = incidentService.getAll();
        model.addAttribute("incidents", incidents);

        return "pages/database/incidents/index";
    }

    /**
     * Displays the form for creating a new insurance incident.
     *
     * @param incident DTO object passed to the form.
     * @return Name of the view template for the creation form.
     */
    @GetMapping ("/create")
        public String renderCreateForm(@ModelAttribute IncidentDTO incident) {
        System.out.println("Zobrazuji formulář pro novou pojistnou událost");
        return "pages/database/incidents/create";
    }

    /**
     * Displays details of a specific insurance incident.
     *
     * @param incidentId ID of the incident.
     * @param model Model for passing data to the view.
     * @return Name of the view template for the detail.
     */
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

    /**
     * Displays the form for editing an insurance incident.
     *
     * @param incidentId ID of the incident.
     * @param incident DTO object for pre-filling the form.
     * @return Name of the view template for the edit form.
     */
    @GetMapping ("/edit/{incidentId}")
    public String renderEditForm(
            @PathVariable long incidentId,
            IncidentDTO incident
    ) {
        IncidentDTO fetchedIncident = incidentService.getById(incidentId);
        incidentMapper.updateIncidentDTO(fetchedIncident, incident);

        return "pages/database/incidents/edit";
    }

    /**
     * Processes the creation of a new insurance incident.
     *On success, redirects to the detail view; otherwise, displays the form with validation errors.
     *
     * @param incident Validated DTO object from the form.
     * @param result Validation results.
     * @param redirectAttributes Flash attributes used after redirect.
     * @return Redirect or name of the form view.
     */
    @PostMapping("/create")
    public String createIncident(
            @Valid @ModelAttribute IncidentDTO incident,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()){
            System.out.println("Formulář obsahuje chyby:" + result.getAllErrors());
            return renderCreateForm(incident);}

        IncidentDTO savedIncident = incidentService.create(incident);
        redirectAttributes.addFlashAttribute("success", "Pojistná událost vytvořena.");

        return "redirect:/database/incidents/" + savedIncident.getIncidentId();
    }

    /**
     * Processes the update of an existing insurance incident.
     * On success, redirects to the list; otherwise, displays the form with validation errors.
     *
     * @param incidentId ID of the edited incident.
     * @param incident DTO object with updated data.
     * @param result Validation results.
     * @param redirectAttributes Flash attributes used after redirect.
     * @return Redirect or name of the form view.
     */
    @PostMapping("/edit/{incidentId}")
    public String editIncident(
            @PathVariable long incidentId,
            @Valid IncidentDTO incident,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors())
            return renderEditForm(incidentId, incident);

        incident.setIncidentId(incidentId);
        incidentService.edit(incident);
        redirectAttributes.addFlashAttribute("success", "Pojistná událost upravena.");

        return "redirect:/database/incidents";
    }

    /**
     * Processes the deletion of an insurance incident.
     *
     * @param incidentId ID of the incident to be deleted.
     * @param redirectAttributes Flash attributes for action confirmation.
     * @return Redirect to the list of incidents.
     */
    @PostMapping("/delete")
    public String deleteIncident(
            @RequestParam("incidentId") long incidentId,
            RedirectAttributes redirectAttributes
    ) {
        incidentService.remove(incidentId);
        redirectAttributes.addFlashAttribute("success", "Pojistná událost smazána.");
        System.out.println("Mazání pojistné události s ID: " + incidentId);

        return "redirect:/database/incidents";
    }

}
