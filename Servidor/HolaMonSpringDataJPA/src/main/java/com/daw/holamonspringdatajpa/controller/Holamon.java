package com.daw.holamonspringdatajpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Holamon  {
    @GetMapping("/")
    String Hola() {
        return "Hola mon";
    }
}