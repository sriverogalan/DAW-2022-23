package org.catalegpelicules.negoci;

import org.catalegpelicules.domini.Genere;
import org.catalegpelicules.domini.Pelicula;

public interface ICatalegPelicules {
    void llistarPelicules();
    void llistarGeneres();
    void crearGenere(Genere nom);

    void crearPelicula(Pelicula pelicula);

    void cercarPelicula(int id);

    void reiniciarCataleg();

    void eliminarPelicula(int id);
    void eliminarGenere(int id);

    void sobreEscriurePelicula(int id, Pelicula pelicula);

    void sobreEscriureGenere(int id, Genere genere);
}
