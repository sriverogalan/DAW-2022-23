package com.daw.facturacio.domini;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
public class LiniesFactura {
    Producte producte;
    int quantitat;
}
