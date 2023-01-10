package com.daw.holamonspringdatajpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ProducteComplex")
public class ProducteComplex extends Producte{
    @Id
    @GeneratedValue(generator = "producte_complex")
    private Long id;
    private String nom;
    private String descripcio;
    private Double preu;
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;
}
