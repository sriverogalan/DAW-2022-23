package org.catalegpelicules.presentacio;
import org.catalegpelicules.dades.IAccessDades;
import org.catalegpelicules.dades.impl.MySQL;
import org.catalegpelicules.dades.impl.PostgreSQL;
import org.catalegpelicules.domini.Genere;
import org.catalegpelicules.domini.Pelicula;
import org.catalegpelicules.negoci.ICatalegPelicules;
import org.catalegpelicules.negoci.impl.CatalegPelicules;
import org.catalegpelicules.texte.Texte;
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
                this.iAccessDades = new PostgreSQL();
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
                this.iCatalegPelicules.llistarGeneres();
                this.menuPrincipal();
                break;
            case 3:
                this.iCatalegPelicules.crearGenere(crearGenere());
                this.menuPrincipal();
                break;
            case 4:
                this.iCatalegPelicules.crearPelicula(indicarPelicula());
                this.menuPrincipal();
                break;
            case 5:
                this.iCatalegPelicules.cercarPelicula(indicarId());
                this.menuPrincipal();
                break;
            case 6:
                System.out.println("Aquests son les pelicules que hi ha :");
                this.iCatalegPelicules.llistarPelicules();
                this.iCatalegPelicules.sobreEscriurePelicula(indicarId(), indicarPelicula());
                this.menuPrincipal();
                break;
            case 7:
                System.out.println("Aquests son els generes que hi ha :");
                this.iCatalegPelicules.llistarGeneres();
                this.iCatalegPelicules.sobreEscriureGenere(indicarId(), sobrescriuGenere());
                this.menuPrincipal();
                break;
            case 8:
                this.iCatalegPelicules.eliminarPelicula(indicarId());
                this.menuPrincipal();
                break;
                case 9:
                this.iCatalegPelicules.eliminarGenere(indicarId());
                this.menuPrincipal();
                break;
            case 10:
                this.iCatalegPelicules.reiniciarCataleg();
                this.menuPrincipal();
                break;
            case 11:
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

        System.out.println("Introdueix el nom del director de la pelicula");
        String director_nom = sc.nextLine();

        System.out.println("Introdueix els llinatges del director de la pelicula");
        String director_llinatges = sc.nextLine();
        String director = director_nom+" "+director_llinatges;

        System.out.println("Generes disponibles:");
        this.iCatalegPelicules.llistarGeneres();

        System.out.println("Eligeix el numero del genere de la pelicula");
        int genere = sc.nextInt();

        System.out.println("Introdueix el any de la pelicula");
        int any = sc.nextInt();

        System.out.println("Introdueix la duracio de la pelicula");
        int duracio = sc.nextInt();

        return new Pelicula(director, titol, genere, any, duracio);
    }

    public int indicarId() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix el id");
        return sc.nextInt();
    }

    public Genere crearGenere() {
        System.out.println("Aquests son els generes que hi ha :");
        this.iCatalegPelicules.llistarGeneres();
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix el nom del genero que vols introduir");
        String nom = sc.nextLine();
        return new Genere(nom);
    }

    public Genere sobrescriuGenere() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix el nom del nou genere");
        String nom = sc.nextLine();
        return new Genere(nom);
    }
}
