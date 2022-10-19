package org.catalegpelicules.domini;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Pelicula {
    private int id;
    private String titol;
    private int any;
    private Director director;
    private Genere genere;
    private int duracio;

    public Pelicula(int id, Director director, Genere genere, String titol, int any, int duracio) {
        this.id = id;
        this.titol = titol;
        this.any = any;
        this.director = director;
        this.genere = genere;
        this.duracio = duracio;
    }

    @Override
    public String toString() {
        return "| Pelicula " +
                "| id " + id +
                "| titol='" + titol + '\'' +
                "| any=" + any +
                "| " + director + '\'' +
                "| " + genere + '\'' +
                "| duracio=" + duracio + '\'' +
                '|';
    }
}
