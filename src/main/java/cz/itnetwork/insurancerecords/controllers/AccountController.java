package cz.itnetwork.insurancerecords.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/account")
public class AccountController {

    @GetMapping("/login")
    public String renderLogin() {

        return "pages/account/login";
    }

    @GetMapping ("/registration")
    public String renderRegistration() {

        return "pages/account/registration";
    }

}
