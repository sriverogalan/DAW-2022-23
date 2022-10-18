package org.catalegpelicules.dades.impl;
import org.catalegpelicules.dades.IAccessDades;
import org.catalegpelicules.domini.Pelicula;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class PosgreSQL implements IAccessDades {
    private Connection connection;
    private boolean isValid;
    public PosgreSQL() {
        try {
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db", "user", "root");
            this.isValid = connection.isValid(50000);
            System.out.println(this.isValid ? "Connection Successful" : "Connection Failed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean existeix(int id) {
        return false;
    }

    @Override
    public List<Pelicula> llistar() {
        return null;
    }

    @Override
    public void actualitzar(int id, Pelicula pelicula) {

    }

    @Override
    public void crear(Pelicula pelicula) {

    }

    @Override
    public void borrar(int id) {

    }

    @Override
    public void cercar(String titol) {

    }

    @Override
    public void tancarConexio() {

    }

    @Override
    public void reiniciarCataleg() {

    }
}
