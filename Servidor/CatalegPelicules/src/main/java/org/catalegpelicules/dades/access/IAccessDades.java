package org.catalegpelicules.dades;

import org.catalegpelicules.domini.Pelicula;

import java.util.List;

public interface IAccessDades {
    boolean existeixCataleg(int id);
    boolean existeixGenere(int id);
    boolean existeixDirector(int id);

    List<Pelicula> llistarCataleg();

    void actualitzarPelicula(int id, Pelicula pelicula);

    void crearPelicules(Pelicula pelicula);
    void crearGenere(Pelicula pelicula);
    void crearDirector(Pelicula pelicula);

    void borrarPelicules(int id);
    void borrarGenere(int id);
    void borrarDirector(int id);

    void cercarPelicula(String titol);
    void cercarGenere(String titol);
    void cercarDirector(String titol);
    void tancarConexio();
    void reiniciarCataleg();
}
