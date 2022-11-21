package com.demospring.demospring.Controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class ProducteControlador2 {
    @GetMapping("/producte2/salutacions")
    String Salutacions(){
        return "Hola mon";
    }

    @GetMapping("/producte2/")
    String Salutacions2(){
        return "Hola mon";
    }


}
