package com.demospring.demospring.controllers;

import com.demospring.demospring.entities.Producte;
import com.demospring.demospring.repositories.ProductRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@org.springframework.web.bind.annotation.RestController // Rest controller retorna json o xml
public class RestController {
    @Autowired
    private ProductRespository productRespository;

    @GetMapping("/add")
    String listProductsJSON(@RequestParam String nom, @RequestParam String descripcio, @RequestParam double preu){
        Producte p = new Producte();
        p.setNom(nom);
        p.setDescripcio(descripcio);
        p.setPreu(preu);
        productRespository.save(p);
        return "Producte creat: " + p.toString();
    }

    @GetMapping("/list")
    List<Producte> products(){
        return (List<Producte>) productRespository.findAll();
    }

}
