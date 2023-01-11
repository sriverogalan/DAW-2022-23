package com.CRUDProductes.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@EqualsAndHashCode(exclude = {"tipus", "proveidor", "detallProducte"})
@AllArgsConstructor
@NoArgsConstructor
public @Data class Producte {
    @Id
    @GeneratedValue
    @Column(name = "id_producte")
    private Long id;
    @Column(name = "nom_producte")
    private String nom;
    @Column(name = "descripcio")
    private String descripcio;
    @Column(name = "preu")
    private double preu;
    @ManyToOne
    @JoinColumn(name = "id_proveidor")
    private Proveidor proveidor;
    @OneToOne
    @JoinColumn(name = "id_detall")
    private DetallProducte detallProducte;
    @ManyToMany
    @JoinTable(
            name = "producte_tipus",
            joinColumns = @JoinColumn(name = "id_producte"),
            inverseJoinColumns = @JoinColumn(name = "id_tipus")
    )
    private Set<Tipus> tipus;
}