package com.demospring.demospring.Entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity @Data
@NoArgsConstructor
public class Producte {
    @Id private int id;
    private String nom;
    private String descripcio;
    private double preu;

    public Producte(String nom, double preu, String descripcio) {
        this.nom = nom;
        this.preu = preu;
        this.descripcio = descripcio;
    }

}
