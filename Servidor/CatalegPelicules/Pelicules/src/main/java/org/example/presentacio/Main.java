package org.example.presentacio;

import org.example.dades.IAccessDades;
import org.example.dades.impl.MySQL;
import org.example.domini.Pelicula;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IAccessDades dataAccess = new MySQL();
        System.out.println("Cream una pelicula a la bd de mysql");

        dataAccess.create(new Pelicula("titol", "director", 1, "Genere", 1), "titol");
        dataAccess.search("titol");
        List<Pelicula> pelicules = dataAccess.list();

        for (Pelicula pelicula : pelicules) {
            System.out.println(pelicula);
        }
        dataAccess.update(new Pelicula("Pelicula 1", "toni", 1, "Genere", 1),"titol");

        for (Pelicula pelicula : pelicules) {
            System.out.println(pelicula);
        }
        dataAccess.delete("Pelicula 1");
        ((MySQL) dataAccess).closeConnection();

    }
}