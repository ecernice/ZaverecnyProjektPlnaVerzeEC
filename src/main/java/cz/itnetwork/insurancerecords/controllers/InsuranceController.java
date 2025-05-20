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

import java.util.List;

@Controller
@RequestMapping ("/database/insurances")
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private InsuranceMapper insuranceMapper;

    @GetMapping
    public String renderIndex(Model model) {
        List<InsuranceDTO> insurances = insuranceService.getAll();
        model.addAttribute("insurances", insurances);

        return "pages/database/insurances/index";
    }

    @GetMapping ("/create")
    public String renderCreateForm(@ModelAttribute InsuranceDTO insured) {
        System.out.println("Zobrazuji formulář pro nové pojištění");
        return "pages/database/insurances/create";
    }

    @ModelAttribute("insuranceTypes")
    public InsuranceType[] insuranceTypes() {
        return InsuranceType.values();
    }

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

    @PostMapping("/create")
    public String createInsurance(
            @Valid @ModelAttribute InsuranceDTO insurance,
            BindingResult result
    ) {
        if (result.hasErrors()){
            System.out.println("Formulář obsahuje chyby:" + result.getAllErrors());
            return renderCreateForm(insurance);}

        InsuranceDTO saved = insuranceService.create(insurance);

        return "redirect:/database/insurances/" + saved.getInsuranceId();
    }

    @PostMapping("/edit/{insuranceId}")
    public String editInsurance(
            @PathVariable long insuranceId,
            @Valid @ModelAttribute("insuranceDTO") InsuranceDTO insurance,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            System.out.println("Formulář obsahuje chyby:" + result.getAllErrors());
            model.addAttribute("insuranceId", insuranceId);
            return "pages/database/insurances/edit";
        }

        insurance.setInsuranceId(insuranceId);
        insuranceService.edit(insurance);

        return "redirect:/database/insurances";
    }

    @PostMapping("/delete")
    public String deleteInsurance(
            @RequestParam("insuranceId") long insuranceId
    ) {
        insuranceService.remove(insuranceId);
        System.out.println("Mazání pojištění s ID: " + insuranceId);

        return "redirect:/database/insurances";
    }


}
