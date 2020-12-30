package com.plates.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meals")
public class MealController {

    @GetMapping("/hello")
    String getHelloWorld() {
        return "Hello world!";
    }
}
