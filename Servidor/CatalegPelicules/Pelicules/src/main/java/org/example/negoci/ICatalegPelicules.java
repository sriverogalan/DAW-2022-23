package org.example.negoci;

import org.example.domini.Pelicula;

public interface ICatalegPelicules {
    void llistarPelicules();
    void afegirPelicula(Pelicula pelicula);
    void cercarPelicula(String titol);
    void reiniciarCataleg();
    void eliminarPelicula(String title);
    void sobreEscriurePelicula(String title, Pelicula pelicula);
}
