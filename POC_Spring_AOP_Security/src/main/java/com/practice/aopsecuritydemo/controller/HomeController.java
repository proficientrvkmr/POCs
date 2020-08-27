package com.practice.aopsecuritydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/welcome")
    public String welcome(@RequestParam(value = "name", defaultValue = "Rkush") String name) {
        System.out.println(getClass() + " ===>> CALLED HERE.");
        return "Hi, Welcome Mr. " + name;
    }

}
