package org.example.domini;
import lombok.*;

@Data
@AllArgsConstructor
public class Pelicula {
    // crear atributs
    private int id;
    private String titol; // String
    private int any; // any de publicació
    private String director; // director
    private String genero; // genere
    private int duracio; // duració en minuts

    public Pelicula(String titol, String director, int any, String genero, int duracio) {
        this.titol = titol;
        this.director = director;
        this.any = any;
        this.genero = genero;
        this.duracio = duracio;
    }


    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titol='" + titol + '\'' +
                ", any=" + any +
                ", director='" + director + '\'' +
                ", genero='" + genero + '\'' +
                ", duracio=" + duracio +
                '}';
    }
}
