package com.controlproductes.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Producte {

    private int id;
    private String nom;
    private double preu;
    private String descripcio;

    public Producte(int id, String nom, double preu, String descripcio) {
        this.id = id;
        this.nom = nom;
        this.preu = preu;
        this.descripcio = descripcio;
    }

    public Producte(String nom, double preu, String descripcio) {
        this.nom = nom;
        this.preu = preu;
        this.descripcio = descripcio;
    }
}