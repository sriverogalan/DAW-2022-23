package com.daw.facturacio.domini;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Component
public class Factura {
    Client client;
    List<LiniesFactura> items; 
}
