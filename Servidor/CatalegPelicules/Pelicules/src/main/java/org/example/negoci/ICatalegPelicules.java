package org.example.negoci;

import org.example.domini.Pelicula;

public interface ICatalegPelicules {
    void llistarPelicules();
    void afegirPelicula(Pelicula pelicula);
    void iniciarCataleg();
    void cercarPelicula(String titol);
}
