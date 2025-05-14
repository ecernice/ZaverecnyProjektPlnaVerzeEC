package cz.itnetwork.insurancerecords.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String renderIndex () {
        return "pages/home/index";
    }

    @GetMapping("/about")
    public String renderAbout() {
        return "pages/home/about";
    }

    @GetMapping("/incidents")
    public String renderIncidents() {
        return "pages/home/incidents";
    }

    @GetMapping("/insurances")
    public String renderInsurances() {
        return "pages/home/insurances";
    }

    @GetMapping("/insureds")
    public String renderInsureds() {
        return "pages/home/insureds";
    }

}
