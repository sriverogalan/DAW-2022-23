package org.example.presentacio;

import org.example.dades.impl.MySQL;
import org.example.domini.Pelicula;

public class Main {
    public static void main(String[] args) {
        Projecte1 projecte1 = new Projecte1();
        projecte1.menu();
    }

    public static void comprobar(){
        MySQL mySQL = new MySQL();
    }

}