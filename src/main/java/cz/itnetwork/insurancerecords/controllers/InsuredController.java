package cz.itnetwork.insurancerecords.controllers;

import cz.itnetwork.insurancerecords.models.dto.InsuredDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/database/insureds")
public class InsuredController {

    @GetMapping
    public String renderIndex() {

        return "pages/database/insureds/index";
    }

    @GetMapping ("/create")
    public String renderCreateForm(@ModelAttribute InsuredDTO insured) {
        System.out.println("Zobrazuji formulář pro nového pojištěnce");
        return "pages/database/insureds/create";
    }

    @GetMapping ("/detail")
    public String renderDetail() {

        return "pages/database/insureds/detail";
    }

    @GetMapping ("/edit")
    public String renderEdit() {

        return "pages/database/insureds/edit";
    }

    @PostMapping("create")
    public String createInsured(
            @Valid @ModelAttribute InsuredDTO insured,
            BindingResult result
    ) {
        if (result.hasErrors()){
            System.out.println("Formulář obsahuje chyby:" + result.getAllErrors());
            return renderCreateForm(insured);}

        // Zde budeme později pracovat s databází
        System.out.println(insured.getSurname() + " – " + insured.getPhoneNumber());

        return "redirect:/articles";
    }

}
