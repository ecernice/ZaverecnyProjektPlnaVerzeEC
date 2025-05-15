package cz.itnetwork.insurancerecords.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/database/insureds")
public class InsuredController {

    @GetMapping
    public String renderIndex() {

        return "pages/database/insureds/index";
    }

    @GetMapping ("/create")
    public String renderCreate() {

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

}
