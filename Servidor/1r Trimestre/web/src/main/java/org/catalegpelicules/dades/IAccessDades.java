package org.catalegpelicules.dades;

import org.catalegpelicules.domini.Genere;
import org.catalegpelicules.domini.Pelicula;

import java.util.List;

public interface IAccessDades {
    List<Pelicula> llistarCataleg();
    List<Pelicula> llistarCatalegOrdenatPerId();
    List<Pelicula> llistarPeliculesOrdenadesPerNom();
    List<Pelicula> llistarPeliculesOrdenadesPerAny();
    List<Pelicula> llistarPeliculesOrdenadesPerDurada();
    List<Pelicula> llistarPeliculesOrdenadesPerDirector();
    List<Pelicula> llistarPeliculesOrdenadesPerGenere();
    List<Genere> llistarGeneres();
    void actualitzarGenere(int id, Genere genere);
    boolean existeixCataleg(int id);
    boolean existeixGenere(int id);
    void actualitzarPelicula(int id, Pelicula pelicula);
    void crearPelicules(Pelicula pelicula);
    void crearGenere(String genere);
    void borrarPelicula(int id);
    void cercarPelicula(int id);
    void borrarGenere(int id);
    void tancarConexio();
    void reiniciarCataleg();
}
