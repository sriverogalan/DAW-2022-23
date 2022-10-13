package org.example.presentacio;

import org.example.dades.IAccessDades;
import org.example.dades.impl.MySQL;
import org.example.domini.Pelicula;
import org.example.negoci.CatalegPelicules;
import org.example.negoci.ICatalegPelicules;
import org.example.texto.Text;

import java.util.*;

public class Projecte1 {
    private IAccessDades accessDades;
    private ICatalegPelicules iCatalegPelicules;

    public Projecte1() {
        Text.menuDatabase();
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equalsIgnoreCase("1")) {
            this.accessDades = new MySQL();
            this.iCatalegPelicules = new CatalegPelicules(this, accessDades);
            this.menu();
        }
    }

    public void menu() {
        Text.menuOptions();
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()) {
            case 1:
                iCatalegPelicules.llistarPelicules();
                this.menu();
                break;
            case 2:
                iCatalegPelicules.crearPelicula(indicarPelicula());
                this.menu();
                break;
            case 3:
                iCatalegPelicules.cercarPelicula(indicarTitol());
                this.menu();
                break;
            case 4:
                iCatalegPelicules.sobreEscriurePelicula(indicarTitol(), indicarPelicula());
                this.menu();
                break;
            case 5:
                iCatalegPelicules.eliminarPelicula(indicarTitol());
                this.menu();
                break;
            case 6:
                iCatalegPelicules.reiniciarCataleg();
                this.menu();
                break;
            case 7:
                System.exit(0);
                break;
            default:
                System.out.println("Has elegit una opcio incorrecta");
                this.menu();
                break;
        }
    }

    public Pelicula indicarPelicula() {
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

    public String indicarTitol() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix el titol de la pelicula");
        return sc.nextLine();
    }

}
