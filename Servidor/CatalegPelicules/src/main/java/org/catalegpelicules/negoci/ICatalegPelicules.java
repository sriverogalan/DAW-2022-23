package org.catalegpelicules.negoci;

import org.catalegpelicules.domini.Pelicula;

public interface ICatalegPelicules {
    void llistarPelicules();

    void crearPelicula(Pelicula pelicula);

    void cercarPelicula(String titol);

    void reiniciarCataleg();

    void eliminarPelicula(String title);

    void sobreEscriurePelicula(String title, Pelicula pelicula);
}
