package com.example.productes.domini;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
public class LiniesFactura {
    Producte producte;
    int quantitat;
}
