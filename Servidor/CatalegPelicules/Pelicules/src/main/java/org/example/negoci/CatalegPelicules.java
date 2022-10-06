package org.example.negoci;

import org.example.dades.IAccessDades;
import org.example.dades.impl.MySQL;
import org.example.domini.Pelicula;
import org.example.presentacio.Projecte1;

import java.util.ArrayList;

public class CatalegPelicules implements ICatalegPelicules {
    private IAccessDades dataAccess;
    private Projecte1 mainMenu;

    public CatalegPelicules(Projecte1 mainMenu, IAccessDades dataAccess) {
        this.mainMenu = mainMenu;
        this.dataAccess = dataAccess;

    }

    @Override
    public void llistarPelicules() {
        ArrayList<Pelicula> pelicules = (ArrayList<Pelicula>) dataAccess.list();
        for (Pelicula pelicula : pelicules) {
            System.out.println(pelicula);
        }
    }
    @Override
    public void afegirPelicula(Pelicula pelicula) {
        dataAccess.create(pelicula, pelicula.getTitol());
    }
    @Override
    public void cercarPelicula(String titol) {
        dataAccess.search(titol);
    }
    @Override
    public void reiniciarCataleg() {

    }
    @Override
    public void eliminarPelicula(String title) {

    }
    @Override
    public void sobreEscriurePelicula(String title, Pelicula pelicula) {

    }
}
