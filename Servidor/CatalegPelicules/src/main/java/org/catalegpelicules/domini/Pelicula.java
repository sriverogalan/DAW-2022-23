package org.catalegpelicules.domini;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Pelicula {

    /*
     * Atributs
     * @id: identificador de la pelicula
     * @titol: titol de la pelicula
     * @director: director de la pelicula
     * @any: any de la pelicula
     * @genere: genero de la pelicula
     * @duracio: duracion de la pelicula
     */

    private int id;
    private String titol;
    private int any;
    private String director;
    private String genero;
    private int duracio;

    public Pelicula(String titol, String director, int any, String genero, int duracio) {
        this.titol = titol;
        this.director = director;
        this.any = any;
        this.genero = genero;
        this.duracio = duracio;
    }


    @Override
    public String toString() {
        return "| Pelicula " +
                "| id " + id +
                "| titol='" + titol + '\'' +
                "| any=" + any +
                "| director='" + director + '\'' +
                "| genero='" + genero + '\'' +
                "| duracio=" + duracio + '\'' +
                '|';
    }
}
