package com.project.ks8.simpleexample.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class PropriedadesTestController {

    @Value("${myapp.prop}")
    private String value;

    @GetMapping
    public String get() {
        return value;
    }
}

