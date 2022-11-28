package com.daw.facturacio.configuration;

import com.daw.facturacio.domini.Factura;
import com.daw.facturacio.domini.LiniesFactura;
import com.daw.facturacio.domini.Producte;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class Config {

    @Bean
    List<LiniesFactura> crearLinies(){
        Producte p1 = new Producte("P1", "Producte 1", 10);
        Producte p2 = new Producte("P2", "Producte 2", 20);
        Producte p3 = new Producte("P3", "Producte 3", 30);

        LiniesFactura l1 = new LiniesFactura(p1, 1);
        LiniesFactura l2 = new LiniesFactura(p2, 2);
        LiniesFactura l3 = new LiniesFactura(p3, 3);

        return Arrays.asList(l1, l2, l3);
    }

}