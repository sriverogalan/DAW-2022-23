package Presentacio;

import Domini.Pelicula;

public class Main {
    public static void main(String[] args) {
        Pelicula pelicula = new Pelicula("Batman", "Christopher Nolan", "Accion", "Batman", null, "2h", "Ingles", "Español", "Apta para todos", "USA");
        System.out.println(pelicula);
    }
}