package org.example.dades.impl;

import org.example.dades.IAccessDades;
import org.example.domini.Pelicula;

import java.util.List;

public class PostgreSQL implements IAccessDades {

    @Override
    public boolean existeix(int id) {
        return false;
    }

    @Override
    public List<Pelicula> llistar() {
        return null;
    }

    @Override
    public void actualitzar(int id, Pelicula pelicula) {

    }

    @Override
    public void crear(Pelicula pelicula) {

    }

    @Override
    public void borrar(int id) {

    }

    @Override
    public void cercar(String titol) {

    }

    @Override
    public void tancarConexio() {

    }

    @Override
    public void reiniciarCataleg() {

    }
}
