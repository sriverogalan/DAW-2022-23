package com.web.web.domini;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Getter
@Setter
public class Pelicula {
    private int id;
    private Genere genere;
    private String director;
    private String titol;
    private int any;
    private int duracio;


    public Pelicula(String director, String titol, int genere, int any, int duracio) {
        this.director = director;
        this.titol = titol;
        this.genere = new Genere(genere);
        this.any = any;
        this.duracio = duracio;
    }

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