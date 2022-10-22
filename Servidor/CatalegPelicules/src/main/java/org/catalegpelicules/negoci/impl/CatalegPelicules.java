package org.catalegpelicules.negoci.impl;

import org.catalegpelicules.dades.IAccessDades;
import org.catalegpelicules.domini.Genere;
import org.catalegpelicules.domini.Pelicula;
import org.catalegpelicules.negoci.ICatalegPelicules;

public class CatalegPelicules implements ICatalegPelicules {
    private final IAccessDades iAccessDades;

    public CatalegPelicules(IAccessDades dataAccess) {
        this.iAccessDades = dataAccess;
    }

    @Override
    public void llistarPelicules() {
        for (Pelicula pelicula : this.iAccessDades.llistarCataleg()) {
            System.out.println(pelicula);
        }
        if (this.iAccessDades.llistarCataleg().isEmpty()) {
            System.out.println("No hi ha cap pelicula");
        }
    }
    @Override
    public void llistarGeneres(){
        for (Genere genere : this.iAccessDades.llistarGeneres()) {
            System.out.println(genere);
        }
        if (this.iAccessDades.llistarGeneres().isEmpty()) {
            System.out.println("No hi ha cap genere");
        }
    }

    @Override
    public void crearGenere(Genere genere) {
        this.iAccessDades.crearGenere(genere.getGenere());
        System.out.println("Genere creat correctament");
    }

    @Override
    public void crearPelicula(Pelicula pelicula) {
        this.iAccessDades.crearPelicules(pelicula);
        System.out.println("Pelicula creada correctament");
    }

    @Override
    public void cercarPelicula(int id) {
        if (this.iAccessDades.existeixCataleg(id)) {
            this.iAccessDades.cercarPelicula(id);
        } else {
            System.out.println("No existeix la pelicula");
        }
    }
    @Override
    public void reiniciarCataleg() {
        this.iAccessDades.reiniciarCataleg();
        System.out.println("Cataleg reiniciat");
    }
    @Override
    public void eliminarPelicula(int id) {
        if (this.iAccessDades.existeixCataleg(id)) {
            this.iAccessDades.borrarPelicula(id);
            System.out.println("Pelicula eliminada");
        } else {
            System.out.println("No existeix la pelicula");
        }
    }

    @Override
    public void eliminarGenere(int id) {
        if (this.iAccessDades.existeixGenere(id)) {
            this.iAccessDades.borrarGenere(id);
            System.out.println("Genere eliminat");
        } else {
            System.out.println("No existeix el genere");
        }
    }

    @Override
    public void sobreEscriurePelicula(int id, Pelicula pelicula) {
        if (this.iAccessDades.existeixCataleg(id)) {
            this.iAccessDades.actualitzarPelicula(id, pelicula);
            System.out.println("Pelicula actualitzada");
        } else {
            System.out.println("No existeix la pelicula");
        }
    }
    @Override
    public void sobreEscriureGenere(int id, Genere genere) {
        if (this.iAccessDades.existeixGenere(id)) {
            this.iAccessDades.actualitzarGenere(id, genere);
            System.out.println("Genere actualitzat");
        } else {
            System.out.println("No existeix el genere");
        }
    }
}
