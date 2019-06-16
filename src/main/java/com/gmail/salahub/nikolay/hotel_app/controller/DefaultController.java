package com.gmail.salahub.nikolay.hotel_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/403")
    public String showErrorPage(){
        return "/error/403";
    }
}
