package com.aplicacio.webaplication.domini;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Pelicula {
    private int id;
    private String titol;
    private String director;
    private String genere;
    private int any;
    private int duracio;

    @Override
    public String toString() {
        return "| Pelicula " +
                "| id " + id +
                "| " + genere + '\'' +
                "| titol='" + titol + '\'' +
                "| any=" + any +
                "| " + director + '\'' +
                "| duracio=" + duracio + '\'' +
                '|';
    }
}