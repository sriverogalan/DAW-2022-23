package com.daw.cataleg.catalegproductes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Lombok to generate getters, setters, toString, equals and hashCode methods
@AllArgsConstructor
@NoArgsConstructor
@Entity // es una entitat de la base de dades
@Table(name = "articles")
public class Product {
    @Id @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "nom")
    private String name;
    @Column(name = "descripcio")
    private String description;
    @Column(name = "preu")
    private Double price;

    public Product(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
