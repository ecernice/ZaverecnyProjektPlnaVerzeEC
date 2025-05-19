package cz.itnetwork.insurancerecords.controllers;

import cz.itnetwork.insurancerecords.models.dto.InsuranceDTO;
import cz.itnetwork.insurancerecords.models.dto.InsuredDTO;
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
        InsuranceDTO insurance = insuranceService.getById(insuranceId);
        model.addAttribute("insurance", insurance);

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

        insuranceService.create(insurance);

        return "redirect:/insurances";
    }

}
