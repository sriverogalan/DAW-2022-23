package com.CRUDProductes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
public @Data class DetallProducte {

    @Id
    @GeneratedValue
    @Column(name = "id_detall")
    private Long id;

    @Column(name = "nom_detall")
    private String nom;
}
