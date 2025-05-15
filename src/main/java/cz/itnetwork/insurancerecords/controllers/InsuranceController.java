package cz.itnetwork.insurancerecords.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/database/insurances")
public class InsuranceController {

    @GetMapping
    public String renderIndex() {

        return "pages/database/insurances/index";
    }

    @GetMapping ("/create")
    public String renderCreate() {

        return "pages/database/insurances/create";
    }

    @GetMapping ("/detail")
    public String renderDetail() {

        return "pages/database/insurances/detail";
    }

    @GetMapping ("/edit")
    public String renderEdit() {

        return "pages/database/insurances/edit";
    }

}
