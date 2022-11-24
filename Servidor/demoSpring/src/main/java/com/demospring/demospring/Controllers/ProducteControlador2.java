package com.demospring.demospring.Controllers;

import com.demospring.demospring.Repositories.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ProducteControlador2 {

    @Autowired
    private ProductRespository productRespository;

    @GetMapping("/")
    String Salutacions(Model model){
        model.addAttribute("productes", productRespository.findAll());

        return "index";
    }



}
