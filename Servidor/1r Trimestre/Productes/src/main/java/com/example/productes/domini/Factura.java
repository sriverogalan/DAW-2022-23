package com.example.productes.domini;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Component
public class Factura {
    @Autowired
    Client client;
    @Autowired
    List<LiniesFactura> items;
}
