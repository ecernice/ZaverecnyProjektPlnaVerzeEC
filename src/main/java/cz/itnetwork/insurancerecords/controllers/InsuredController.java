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

import java.util.List;

@Controller
@RequestMapping ("/database/insureds")
public class InsuredController {

    @Autowired
    private InsuredService insuredService;

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private InsuredMapper insuredMapper;

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
        List<InsuranceDTO> insurances = insuranceService.getByInsuredId(insuredId);

        model.addAttribute("insured", insured);
        model.addAttribute("insurances", insurances);
        System.out.println("Zobrazuji detail pojištěnce");

        return "pages/database/insureds/detail";
    }

    @GetMapping ("/edit/{insuredId}")
    public String renderEditForm(
            @PathVariable long insuredId,
            InsuredDTO insured
    ) {
        InsuredDTO fetchedInsured = insuredService.getById(insuredId);
        insuredMapper.updateInsuredDTO(fetchedInsured, insured);

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

        InsuredDTO savedInsured = insuredService.create(insured);

        return "redirect:/database/insureds/" + savedInsured.getInsuredId();
    }

    @PostMapping("/edit/{insuredId}")
    public String editInsured(
            @PathVariable long insuredId,
            @Valid InsuredDTO insured,
            BindingResult result
    ) {
        if (result.hasErrors()){
            System.out.println("Formulář obsahuje chyby:" + result.getAllErrors());
            return renderEditForm(insuredId, insured);}

        insured.setInsuredId(insuredId);
        insuredService.edit(insured);

        return "redirect:/database/insureds";
    }

}
