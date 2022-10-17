package org.catalegpelicules.negoci.impl;

import org.catalegpelicules.dades.IAccessDades;
import org.catalegpelicules.domini.Pelicula;
import org.catalegpelicules.negoci.ICatalegPelicules;

public class CatalegPelicules implements ICatalegPelicules {
    private final IAccessDades iAccessDades;

    public CatalegPelicules(IAccessDades dataAccess) {
        this.iAccessDades = dataAccess;
    }

    @Override
    public void llistarPelicules() {
        for (Pelicula pelicula : this.iAccessDades.llistar()) {
            System.out.println(pelicula);
        }
        if (this.iAccessDades.llistar().isEmpty()) {
            System.out.println("No hi ha cap pelicula");
        }
    }

    @Override
    public void crearPelicula(Pelicula pelicula) {
        this.iAccessDades.crear(pelicula);
    }

    @Override
    public void cercarPelicula(String titol) {
        this.iAccessDades.cercar(titol);
    }

    @Override
    public void reiniciarCataleg() {
        this.iAccessDades.reiniciarCataleg();
    }

    @Override
    public void eliminarPelicula(String title) {
        for (Pelicula pelicula : this.iAccessDades.llistar()) {
            if (pelicula.getTitol().equals(title)) {
                if (this.iAccessDades.existeix(pelicula.getId())) this.iAccessDades.borrar(pelicula.getId());
            } else System.out.println("No existeix o no es troba la pelicula");
        }
    }

    @Override
    public void sobreEscriurePelicula(String title, Pelicula pelicula) {
        for (Pelicula p : this.iAccessDades.llistar()) {
            if (p.getTitol().equals(title)) {
                if (this.iAccessDades.existeix(pelicula.getId())) this.iAccessDades.actualitzar(p.getId(), pelicula);
            } else System.out.println("No existeix o no es troba la pelicula");
        }
    }
}
