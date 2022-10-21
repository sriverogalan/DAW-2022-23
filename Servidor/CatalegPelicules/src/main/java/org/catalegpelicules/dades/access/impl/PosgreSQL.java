package org.catalegpelicules.dades.access;
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
    public boolean existeixCataleg(int id) {
        return false;
    }

    @Override
    public List<Pelicula> llistarCataleg() {
        return null;
    }

    @Override
    public void actualitzarPelicula(int id, Pelicula pelicula) {

    }

    @Override
    public void crearPelicules(Pelicula pelicula) {

    }

    @Override
    public void borrarPelicules(int id) {

    }

    @Override
    public void cercarPelicula(String titol) {

    }

    @Override
    public void tancarConexio() {

    }

    @Override
    public void reiniciarCataleg() {

    }
}
