package com.daw.cataleg.catalegproductes.controller;

import com.daw.cataleg.catalegproductes.entity.Product;
import com.daw.cataleg.catalegproductes.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class MainController {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/")
    public String index(Model model) {
        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "index";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam Long id) {
        productRepository.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping("/view")
    public String view(@RequestParam Long id, Model model) {
        Product product = productRepository.findById(id).get();
        model.addAttribute("product", product);
        return "view";
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam Long id, Model model) {
        Product product = productRepository.findById(id).get();
        model.addAttribute("product", product);
        return "edit";
    }

    @RequestMapping("/save")
    public String save(@RequestParam Long id, @RequestParam String name, @RequestParam String description, @RequestParam String price) {
        Product product = productRepository.findById(id).get();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(Double.valueOf(price));
        productRepository.save(product);
        return "redirect:/";
    }

    @RequestMapping("/add")
    public String add(@RequestParam String name, @RequestParam String description, @RequestParam String price) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(Double.valueOf(price));
        productRepository.save(product);
        return "add";
    }

}
