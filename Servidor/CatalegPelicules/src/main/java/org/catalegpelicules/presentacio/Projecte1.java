package org.catalegpelicules.presentacio;

import org.catalegpelicules.dades.IAccessDades;
import org.catalegpelicules.dades.impl.MySQL;
import org.catalegpelicules.dades.impl.PosgreSQL;
import org.catalegpelicules.domini.Pelicula;
import org.catalegpelicules.negoci.ICatalegPelicules;
import org.catalegpelicules.negoci.impl.CatalegPelicules;
import org.example.texte.Texte;

import java.util.Scanner;

public class Projecte1 {
    private ICatalegPelicules iCatalegPelicules;
    private IAccessDades iAccessDades;

    public Projecte1() {
        this.seleccioBaseDeDades();
    }

    public void seleccioBaseDeDades() {
        Texte.menuBaseDeDades();
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1:
                this.iAccessDades = new MySQL();
                this.iCatalegPelicules = new CatalegPelicules(iAccessDades);
                this.menuPrincipal();
                break;
            case 2:
                this.iAccessDades = new PosgreSQL();
                this.iCatalegPelicules = new CatalegPelicules(iAccessDades);
                break;
            default:
                System.out.println("Opció incorrecta");
                this.seleccioBaseDeDades();
                break;
        }
    }

    public void menuPrincipal() {
        Texte.separtacio();
        Texte.menuOpcions();
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()) {
            case 1:
                this.iCatalegPelicules.llistarPelicules();
                this.menuPrincipal();
                break;
            case 2:
                this.iCatalegPelicules.crearPelicula(indicarPelicula());
                this.menuPrincipal();
                break;
            case 3:
                this.iCatalegPelicules.cercarPelicula(indicarTitol());
                this.menuPrincipal();
                break;
            case 4:
                this.iCatalegPelicules.sobreEscriurePelicula(indicarTitol(), indicarPelicula());
                this.menuPrincipal();
                break;
            case 5:
                this.iCatalegPelicules.eliminarPelicula(indicarTitol());
                this.menuPrincipal();
                break;
            case 6:
                this.iCatalegPelicules.reiniciarCataleg();
                this.menuPrincipal();
                break;
            case 7:
                this.iAccessDades.tancarConexio();
                System.out.println("S'ha tancat la conexio amb la base de dades i has sortit del programa fora cap problmea");
                System.exit(0);
                break;
            default:
                System.out.println("Has elegit una opcio incorrecta");
                this.menuPrincipal();
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
