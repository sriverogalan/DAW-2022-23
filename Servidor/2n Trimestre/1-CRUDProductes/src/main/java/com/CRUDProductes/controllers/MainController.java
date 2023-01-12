package com.CRUDProductes.controllers;

import com.CRUDProductes.models.DetallProducte;
import com.CRUDProductes.models.Producte;
import com.CRUDProductes.models.Proveidor;
import com.CRUDProductes.models.Tipus;
import com.CRUDProductes.repositories.DetallProducteRepository;
import com.CRUDProductes.repositories.ProducteRepository;
import com.CRUDProductes.repositories.ProveidorRepository;
import com.CRUDProductes.repositories.TipusRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    private final DetallProducteRepository detallProducteRepository;
    private ProducteRepository producteRepository;
    private ProveidorRepository proveidorRepository;
    private TipusRepository tipusRepository;

    public MainController(DetallProducteRepository detallProducteRepository, ProducteRepository producteRepository, ProveidorRepository proveidorRepository, TipusRepository tipusRepository) {
        this.detallProducteRepository = detallProducteRepository;
        this.producteRepository = producteRepository;
        this.proveidorRepository = proveidorRepository;
        this.tipusRepository = tipusRepository;
    }

    @RequestMapping("/")
    public String index(Model model) {
        Iterable<Producte> products = producteRepository.findAll();
        model.addAttribute("products", products);
        return "index";
    }

    @RequestMapping("/addProduct")
    public String addProduct(Model model) {
        Iterable<Proveidor> proveidorRepository = this.proveidorRepository.findAll();
        Iterable<Tipus> tipusRepository = this.tipusRepository.findAll();
        Iterable<DetallProducte> detallProducteRepository = this.detallProducteRepository.findAll();
        model.addAttribute("proveidors", proveidorRepository);
        model.addAttribute("tipus", tipusRepository);
        model.addAttribute("detallProductes",  detallProducteRepository);
        return "addProduct";
    }

    @PostMapping("/add")
    public String addProduct(Producte producte) {
        producteRepository.save(producte);
        return "redirect:/";
    }
}