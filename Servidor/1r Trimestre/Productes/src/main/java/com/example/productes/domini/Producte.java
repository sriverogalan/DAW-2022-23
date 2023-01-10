package com.example.productes.domini;

import lombok.*;
import org.springframework.stereotype.Component;

@Data @AllArgsConstructor @NoArgsConstructor @Component
public class Producte {
    String nom;
    String descripcio;
    float preu;
}
