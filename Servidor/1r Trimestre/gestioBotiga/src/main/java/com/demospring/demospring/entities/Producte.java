package com.demospring.demospring.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "productesJAVA")
@Data
public class Producte {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "descripcio")
    private String descripcio;

    @Column(name = "preu")
    private double preu;

}
