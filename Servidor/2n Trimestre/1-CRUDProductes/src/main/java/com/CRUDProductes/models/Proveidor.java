package com.CRUDProductes.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Entity
@EqualsAndHashCode(exclude = {"productes"})
public @Data class Proveidor {
    @Id
    @GeneratedValue
    @Column(name = "id_proveidor")
    private Long id;
    @Column(name = "nom_proveidor")
    private String nom;
}
