package com.daw.cataleg.catalegproductes.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {
    // Crear un controlador rest que ens mostri per pantalla salutacions
    @ResponseBody
    @RequestMapping(value = "/salutacions", method = RequestMethod.GET)
    public String salutacions() {
        return "Hola";
    }


}
