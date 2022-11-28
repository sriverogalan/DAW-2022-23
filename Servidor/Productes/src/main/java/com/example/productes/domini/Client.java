package com.example.productes.domini;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data @NoArgsConstructor @AllArgsConstructor @Component
public class Client {
    @Value("${client.nom}")
    String nom;
    @Value("${client.llinatges}")
    String llinatges;
}
