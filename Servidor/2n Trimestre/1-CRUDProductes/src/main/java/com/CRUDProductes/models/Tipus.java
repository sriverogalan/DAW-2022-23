package com.CRUDProductes.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Entity
public @Data class Tipus {
    @Id
    @GeneratedValue
    @Column(name = "id_tipus")
    private Long id;

    @Column(name = "nom_tipus")
    private String nom;
}
