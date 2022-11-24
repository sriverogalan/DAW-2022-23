package com.demospring.demospring.Controllers;

import com.demospring.demospring.Entities.Producte;
import com.demospring.demospring.Repositories.ProductRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController // Rest controller retorna json o xml
public class ProducteControlador {

    @Autowired
    private ProductRespository productRespository;

    @GetMapping("/add")
    String Saludar(@RequestParam String nom, @RequestParam String descripcio, @RequestParam double preu){
        Producte p = new Producte();
        p.setNom(nom);
        p.setDescripcio(descripcio);
        p.setPreu(preu);
        productRespository.save(p);
        return "Producte creat: " + p.toString();
    }

    @GetMapping("/list")
    List<Producte> Producte(){
        return (List<Producte>) productRespository.findAll();
    }


}
