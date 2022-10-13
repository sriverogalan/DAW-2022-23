package org.example.dades;

import org.example.domini.Pelicula;

import java.util.List;

public interface IAccessDades {
    boolean existeix(int id);
    List<Pelicula> llistar();
    void actualitzar(int id, Pelicula pelicula);
    void crear(Pelicula pelicula);
    void borrar(int id);
    void cercar(String titol);
    void tancarConexio();
    void reiniciarCataleg();
}
