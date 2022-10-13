package org.example.presentacio;

import org.example.dades.IAccessDades;
import org.example.dades.impl.MySQL;
import org.example.domini.Pelicula;
import org.example.negoci.CatalegPelicules;
import org.example.negoci.ICatalegPelicules;

import java.util.*;

public class Projecte1 {
    private IAccessDades accessDades;
    private ICatalegPelicules iCatalegPelicules;

    public Projecte1() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equalsIgnoreCase("1")) {
            this.accessDades = new MySQL();
            this.iCatalegPelicules = new CatalegPelicules(this, accessDades);
            this.menu();
        }
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix el numero que vols que faci el programa :");
        System.out.println("1. Llistat de pelicules");
        System.out.println("2. Crear pelicula");
        System.out.println("3. Cercar pelicula per id");
        System.out.println("4. Canvis a una pelicula");
        System.out.println("5. Borrar una pelicula");
        switch (sc.nextInt()) {
            case 1:
                System.out.println("Has seleccionat llistar pelicules");
                break;
            case 2:
                System.out.println("Has escollit crear una pelicula");
                indicarPelicula();
                break;
            default:
                System.out.println("Has elegit una opcio incorrecta");
                break;
        }
    }
    public Pelicula indicarPelicula(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Introdueix el titol de la pelicula");
        String titol = sc.nextLine();
        System.out.println("Introdueix el director de la pelicula");
        String director = sc.nextLine();
        System.out.println("Introdueix el genero de la pelicula");
        String genero = sc.nextLine();
        System.out.println("Introdueix el any de la pelicula");
        int any = sc.nextInt();
        System.out.println("Introdueix la duracio de la pelicula");
        int duracio = sc.nextInt();
        return new Pelicula(titol, director, any, genero, duracio);
    }

    public String indicarTitol(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix el titol de la pelicula");
        return sc.nextLine();
    }

}
