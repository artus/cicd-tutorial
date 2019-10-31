package com.github.artus.cicdtutorial.controller;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class HelloWorldController {

    @GetMapping
    public String getHelloWorld() {
        return "Hello World!";
    }

    @PostMapping
    public String getHelloForName(@RequestParam String name) {
        return "Hello " + name + "!";
    }
}
