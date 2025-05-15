package cz.itnetwork.insurancerecords.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/database/incidents")
public class IncidentController {

    @GetMapping
    public String renderIndex() {

        return "pages/database/incidents/index";
    }

    @GetMapping ("/create")
    public String renderCreate() {

        return "pages/database/incidents/create";
    }

    @GetMapping ("/detail")
    public String renderDetail() {

        return "pages/database/incidents/detail";
    }

    @GetMapping ("/edit")
    public String renderEdit() {

        return "pages/database/incidents/edit";
    }

}
