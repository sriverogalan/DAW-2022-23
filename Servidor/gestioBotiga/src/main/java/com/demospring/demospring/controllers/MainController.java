package com.demospring.demospring.controllers;

import com.demospring.demospring.repositories.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MainController {
    @Autowired
    private ProductRespository productRespository;

    /* List of products */
    @RequestMapping(value = { "/", "/index" })
    String listProducts(Model model){
        model.addAttribute("productes", productRespository.findAll());
        return "index";
    }

    /* Add product */
    @RequestMapping(value = { "/add" })
    String addProduct(Model model){
        return "add";
    }



}
