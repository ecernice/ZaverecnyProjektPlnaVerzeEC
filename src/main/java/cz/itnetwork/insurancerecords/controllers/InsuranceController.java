package cz.itnetwork.insurancerecords.controllers;

import cz.itnetwork.insurancerecords.models.dto.InsuranceDTO;
import cz.itnetwork.insurancerecords.models.dto.mappers.InsuranceMapper;
import cz.itnetwork.insurancerecords.models.enums.InsuranceType;
import cz.itnetwork.insurancerecords.models.services.InsuranceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Controller for managing insurances.
 * Provides endpoints for listing, viewing details, creating, editing, and deleting insurances.
 */
@Controller
@RequestMapping ("/database/insurances")
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private InsuranceMapper insuranceMapper;

    /**
     * Displays a list of all insurances.
     *
     * @param model Model for passing data to the view.
     * @return Name of the view template for the list.
     */
    @GetMapping
    public String renderIndex(Model model) {
        List<InsuranceDTO> insurances = insuranceService.getAll();
        model.addAttribute("insurances", insurances);

        return "pages/database/insurances/index";
    }

    /**
     * Displays the form for creating a new insurance.
     *
     * @param insured DTO object passed to the form.
     * @return Name of the view template for the creation form.
     */
    @GetMapping ("/create")
    public String renderCreateForm(@ModelAttribute InsuranceDTO insured) {
        System.out.println("Zobrazuji formulář pro nové pojištění");
        return "pages/database/insurances/create";
    }

    /**
     * Represents insurance type values prescripted in enum class InsuranceType
     *
     * @return An Array od constants - values of InsuranceType
     */
    @ModelAttribute("insuranceTypes")
    public InsuranceType[] insuranceTypes() {
        return InsuranceType.values();
    }

    /**
     * Displays details of a specific insurance.
     *
     * @param insuranceId ID of the insurance.
     * @param model Model for passing data to the view.
     * @return Name of the view template for the detail.
     */
    @GetMapping ("{insuranceId}")
    public String renderDetail(
        @PathVariable long insuranceId,
                Model model
    ) {
        System.out.println("Načítám detail pojištění s ID: " + insuranceId);

        InsuranceDTO insurance = insuranceService.getById(insuranceId);
        System.out.println("Načtené pojištění: " + insurance);

        if (insurance == null) {
            throw new RuntimeException("Pojištění nebylo nalezeno!");
        }
        model.addAttribute("insurance", insurance);
        System.out.println("Zobrazuji detail pojištění");

        return "pages/database/insurances/detail";
    }

    /**
     * Displays the form for editing an insurance.
     *
     * @param insuranceId ID of the insurance.
     * @param model DTO object for pre-filling the form. The model is used to add attributes InsuranceDTO, which represents the specific insurance and
     *              insuranceId - ID of edited insurance.
     * @return Name of the view template for the edit form.
     */
    // The model was added to solve the rendering LocalDate problem, which was later solved by adding @DataTimeFormat annotation to DTO, but the model was left, because it's functional.
    @GetMapping ("/edit/{insuranceId}")
    public String renderEditForm(
            @PathVariable long insuranceId,
            Model model
    ) {
        InsuranceDTO fetchedInsurance = insuranceService.getById(insuranceId);
        model.addAttribute("insuranceDTO", fetchedInsurance);
        model.addAttribute("insuranceId", insuranceId);

        System.out.println("validFrom: " + fetchedInsurance.getValidFrom());
        System.out.println("validTo: " + fetchedInsurance.getValidTo());

        return "pages/database/insurances/edit";
    }

    /**
     * Processes the creation of a new insurance.
     *On success, redirects to the detail view; otherwise, displays the form with validation errors.
     *
     * @param insurance Validated DTO object from the form.
     * @param result Validation results.
     * @param redirectAttributes Flash attributes used after redirect.
     * @return Redirect or name of the form view.
     */
    @PostMapping("/create")
    public String createInsurance(
            @Valid @ModelAttribute InsuranceDTO insurance,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()){
            System.out.println("Formulář obsahuje chyby:" + result.getAllErrors());
            return renderCreateForm(insurance);}

        InsuranceDTO saved = insuranceService.create(insurance);
        redirectAttributes.addFlashAttribute("success", "Pojištění vytvořeno.");

        return "redirect:/database/insurances/" + saved.getInsuranceId();
    }

    /**
     * Processes the update of an existing insurance.
     * On success, redirects to the list; otherwise, displays the form with validation errors.
     *
     * @param insuranceId ID of the edited insurance.
     * @param insurance DTO object with updated data.
     * @param result Validation results.
     * @param model DTO object for adding the insuranceId attribute.
     * @param redirectAttributes Flash attributes used after redirect.
     * @return Redirect or name of the form view.
     */
    @PostMapping("/edit/{insuranceId}")
    public String editInsurance(
            @PathVariable long insuranceId,
            @Valid @ModelAttribute("insuranceDTO") InsuranceDTO insurance,
            BindingResult result,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()) {
            System.out.println("Formulář obsahuje chyby:" + result.getAllErrors());
            model.addAttribute("insuranceId", insuranceId);
            return "pages/database/insurances/edit";
        }

        insurance.setInsuranceId(insuranceId);
        insuranceService.edit(insurance);
        redirectAttributes.addFlashAttribute("success", "Pojištění upraveno.");

        return "redirect:/database/insurances";
    }

    /**
     * Processes the deletion of an insurance.
     *
     * @param insuranceId ID of the insurance to be deleted.
     * @param redirectAttributes Flash attributes for action confirmation.
     * @return Redirect to the list of incidents.
     */
    @PostMapping("/delete")
    public String deleteInsurance(
            @RequestParam("insuranceId") long insuranceId,
            RedirectAttributes redirectAttributes
    ) {
        insuranceService.remove(insuranceId);
        redirectAttributes.addFlashAttribute("success", "Pojištění smazáno.");
        System.out.println("Mazání pojištění s ID: " + insuranceId);

        return "redirect:/database/insurances";
    }


}
