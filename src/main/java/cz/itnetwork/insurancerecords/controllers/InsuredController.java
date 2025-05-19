package cz.itnetwork.insurancerecords.controllers;

import cz.itnetwork.insurancerecords.models.dto.InsuredDTO;
import cz.itnetwork.insurancerecords.models.services.InsuredService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping ("/database/insureds")
public class InsuredController {

    @Autowired
    private InsuredService insuredService;

    @GetMapping
    public String renderIndex(Model model) {
        List<InsuredDTO> insureds = insuredService.getAll();
        model.addAttribute("insureds", insureds);

        return "pages/database/insureds/index";
    }

    @GetMapping ("/create")
    public String renderCreateForm(@ModelAttribute InsuredDTO insured) {
        System.out.println("Zobrazuji formulář pro nového pojištěnce");
        return "pages/database/insureds/create";
    }

    @GetMapping ("{insuredId}")
    public String renderDetail(
            @PathVariable long insuredId,
            Model model
    ) {
        InsuredDTO insured = insuredService.getById(insuredId);
        if (insured == null) {
            throw new RuntimeException("Pojištěnec nebyl nalezen!");
        }
        model.addAttribute("insured", insured);
        System.out.println("Zobrazuji detail pojištěnce");

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

        insuredService.create(insured);

        return "redirect: database/insureds";
    }

}
