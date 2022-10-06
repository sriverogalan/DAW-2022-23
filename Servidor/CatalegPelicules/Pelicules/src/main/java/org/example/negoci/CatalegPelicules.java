package org.example.negoci;

import org.example.dades.IAccessDades;
import org.example.dades.impl.MySQL;
import org.example.domini.Pelicula;

import java.util.ArrayList;

public class CatalegPelicules implements ICatalegPelicules {
    private IAccessDades accessDades = new MySQL();


    @Override
    public void llistarPelicules() {
        ArrayList<Pelicula> pelicules = (ArrayList<Pelicula>) accessDades.list();
        for (Pelicula pelicula : pelicules) {
            System.out.println(pelicula);
        }
    }

    @Override
    public void afegirPelicula(Pelicula pelicula) {
        accessDades.create(pelicula, pelicula.getTitol());
    }

    @Override
    public void iniciarCataleg() {
        accessDades.mostrarNomPelicules();
    }

    @Override
    public void cercarPelicula(String titol) {
        accessDades.search(titol);
    }
}
