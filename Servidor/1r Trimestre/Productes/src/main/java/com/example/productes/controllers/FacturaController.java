package com.example.productes.controllers;

import com.example.productes.domini.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/factura")
public class FacturaController {
    @Autowired
    private Factura factura;

    @GetMapping("/show")
    Factura veureFacturra(Model model){
        return factura;
    }

}
