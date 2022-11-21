package com.demospring.demospring.Controllers;

import com.demospring.demospring.Entities.Producte;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController // Rest controller retorna json o xml
public class ProducteControlador {
    @GetMapping("/")
    String Saludar(){
        return "Hola mon";
    }

    @GetMapping("/producte")
    Producte Producte(){
        return new Producte("Producte 1", 10.0, "Descripció del producte 1");
    }


}
