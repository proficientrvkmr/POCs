package com.spring.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/greeting")
    public String indexPage(Model model) {
        model.addAttribute("message", "Hello, Spring MVC Welcomes You !!!");

        return "greeting";
    }
}
