package com.example.practice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
    @GetMapping
    public String main() {
        return "oh my god inhuman reaction";
    }
}
