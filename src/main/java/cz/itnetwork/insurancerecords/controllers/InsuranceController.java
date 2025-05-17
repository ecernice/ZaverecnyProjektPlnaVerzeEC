package cz.itnetwork.insurancerecords.controllers;

import cz.itnetwork.insurancerecords.models.dto.InsuranceDTO;
import cz.itnetwork.insurancerecords.models.dto.InsuredDTO;
import cz.itnetwork.insurancerecords.models.enums.InsuranceType;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/database/insurances")
public class InsuranceController {

    @GetMapping
    public String renderIndex() {

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

    @GetMapping ("/detail")
    public String renderDetail() {

        return "pages/database/insurances/detail";
    }

    @GetMapping ("/edit")
    public String renderEdit() {

        return "pages/database/insurances/edit";
    }

    @PostMapping("create")
    public String createInsurance(
            @Valid @ModelAttribute InsuranceDTO insurance,
            BindingResult result
    ) {
        if (result.hasErrors()){
            System.out.println("Formulář obsahuje chyby:" + result.getAllErrors());
            return renderCreateForm(insurance);}

        // Zde budeme později pracovat s databází
        System.out.println(insurance.getInsuranceType() + " – " + insurance.getInsuranceSubject());

        return "redirect:/insurances";
    }

}
