package cz.itnetwork.insurancerecords.controllers;

import cz.itnetwork.insurancerecords.models.dto.InsuranceDTO;
import cz.itnetwork.insurancerecords.models.dto.InsuredDTO;
import cz.itnetwork.insurancerecords.models.dto.mappers.InsuredMapper;
import cz.itnetwork.insurancerecords.models.services.InsuranceService;
import cz.itnetwork.insurancerecords.models.services.InsuredService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Controller for managing insureds.
 * Provides endpoints for listing, viewing details, creating, editing, and deleting insureds.
 */
@Controller
@RequestMapping ("/database/insureds")
public class InsuredController {

    @Autowired
    private InsuredService insuredService;

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private InsuredMapper insuredMapper;

    /**
     * Displays a list of all insureds.
     *
     * @param model Model for passing data to the view.
     * @return Name of the view template for the list.
     */
    @GetMapping
    public String renderIndex(Model model) {
        List<InsuredDTO> insureds = insuredService.getAll();
        model.addAttribute("insureds", insureds);

        return "pages/database/insureds/index";
    }

    /**
     * Displays the form for creating a new insured.
     *
     * @param insured DTO object passed to the form.
     * @return Name of the view template for the creation form.
     */
    @GetMapping ("/create")
    public String renderCreateForm(@ModelAttribute InsuredDTO insured) {
        System.out.println("Zobrazuji formulář pro nového pojištěnce");

        return "pages/database/insureds/create";
    }

    /**
     * Displays details of a specific insured.
     *
     * @param insuredId ID of the insured.
     * @param model Model for passing data to the view.
     * @return Name of the view template for the detail.
     */
    @GetMapping ("{insuredId}")
    public String renderDetail(
            @PathVariable long insuredId,
            Model model
    ) {
        InsuredDTO insured = insuredService.getById(insuredId);
        if (insured == null) {
            throw new RuntimeException("Pojištěnec nebyl nalezen!");
        }
        List<InsuranceDTO> insurances = insuranceService.getByInsuredId(insuredId);

        model.addAttribute("insured", insured);
        model.addAttribute("insurances", insurances);
        System.out.println("Zobrazuji detail pojištěnce");

        return "pages/database/insureds/detail";
    }

    /**
     * Displays the form for editing an insureds.
     *
     * @param insuredId ID of the insured.
     * @param insured DTO object for pre-filling the form.
     * @return Name of the view template for the edit form.
     */
    @GetMapping ("/edit/{insuredId}")
    public String renderEditForm(
            @PathVariable long insuredId,
            InsuredDTO insured
    ) {
        InsuredDTO fetchedInsured = insuredService.getById(insuredId);
        insuredMapper.updateInsuredDTO(fetchedInsured, insured);

        return "pages/database/insureds/edit";
    }

    /**
     * Processes the creation of a new insured.
     * On success, redirects to the detail view; otherwise, displays the form with validation errors.
     *
     * @param insured Validated DTO object from the form.
     * @param result Validation results.
     * @param redirectAttributes Flash attributes used after redirect.
     * @return Redirect or name of the form view.
     */
    @PostMapping("/create")
    public String createInsured(
            @Valid @ModelAttribute InsuredDTO insured,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()){
            System.out.println("Formulář obsahuje chyby:" + result.getAllErrors());
            return renderCreateForm(insured);}

        InsuredDTO savedInsured = insuredService.create(insured);
        redirectAttributes.addFlashAttribute("success", "Pojištěnec vytvořen.");

        return "redirect:/database/insureds/" + savedInsured.getInsuredId();
    }

    /**
     * Processes the update of an existing insured.
     * On success, redirects to the list; otherwise, displays the form with validation errors.
     *
     * @param insuredId ID of the edited insured.
     * @param insured DTO object with updated data.
     * @param result Validation results.
     * @param redirectAttributes Flash attributes used after redirect.
     * @return Redirect or name of the form view.
     */
    @PostMapping("/edit/{insuredId}")
    public String editInsured(
            @PathVariable long insuredId,
            @Valid InsuredDTO insured,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()){
            System.out.println("Formulář obsahuje chyby:" + result.getAllErrors());
            return renderEditForm(insuredId, insured);}

        insured.setInsuredId(insuredId);
        insuredService.edit(insured);
        redirectAttributes.addFlashAttribute("success", "Pojištěnec upraven.");

        return "redirect:/database/insureds";
    }

    /**
     * Processes the deletion of insured.
     *
     * @param insuredId ID of the insured to be deleted.
     * @param redirectAttributes Flash attributes for action confirmation.
     * @return Redirect to the list of incidents.
     */
    @PostMapping("/delete")
    public String deleteInsured(
            @RequestParam("insuredId") long insuredId,
            RedirectAttributes redirectAttributes
    ) {
        insuredService.remove(insuredId);
        redirectAttributes.addFlashAttribute("success", "Pojištěnec smazán.");
        System.out.println("Mazání pojištěnce s ID: " + insuredId);

        return "redirect:/database/insureds";
    }


}
