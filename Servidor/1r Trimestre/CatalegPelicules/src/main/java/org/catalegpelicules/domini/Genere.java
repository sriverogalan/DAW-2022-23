package org.catalegpelicules.domini;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;

@Getter
@Setter
public class Genere {
    private int id;
    private String genere;

    public Genere(int id){
        this.id = id;
    }
    public Genere(String genere){
        this.genere = genere;
    }

    public Genere(int id, String nom) {
        this.id = id;
        this.genere = nom;
    }

    @Override
    public String toString() {
        return "Genere{" +
                "id=" + id +
                ", nom='" + genere + '\'' +
                '}';
    }
}
