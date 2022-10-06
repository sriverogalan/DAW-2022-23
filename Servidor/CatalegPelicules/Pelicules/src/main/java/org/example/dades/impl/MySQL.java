package org.example.dades.impl;

import org.example.dades.IAccessDades;
import org.example.domini.Pelicula;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQL implements IAccessDades {

    private Connection connection;
    private final String url = "jdbc:mysql://localhost:3306/prova";
    private String user = "root";
    private String password = "root";

    public MySQL() {
        try {
            this.connection = DriverManager.getConnection(url, user, password);
            System.out.println("Se ha conectado correctamente a la base de datos");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Pelicula> list() {
        List<Pelicula> llistaPelicules = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM catalegpelicules");
            while (rs.next()) {
                Pelicula pelicula = new Pelicula(rs.getInt("id"), rs.getString("titol"), rs.getInt("any"), rs.getString("director"), rs.getString("genere"), rs.getInt("duracio"));
                llistaPelicules.add(pelicula);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return llistaPelicules;
    }
    @Override
    public boolean exists(String title) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM catalegpelicules WHERE titol LIKE '" + title + "'");
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public void preparedStatementConection(String sql, Pelicula film) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, film.getTitol());
            preparedStatement.setInt(2, film.getAny());
            preparedStatement.setString(3, film.getDirector());
            preparedStatement.setString(4, film.getGenero());
            preparedStatement.setInt(5, film.getDuracio());
            preparedStatement.execute();
            System.out.println("Se ha pujat correctament a la base de dades");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void create(Pelicula pelicula, String titol) {
        String sql = "INSERT INTO catalegpelicules (titol, any, director, genere, duracio) VALUES (?, ?, ?, ?, ?)";
        if (!exists(titol)){preparedStatementConection(sql, pelicula);} else { System.out.println("La pelicula ja existeix"); }

    }
    @Override
    public void search(String title) {
        try {
            if (exists(title)) {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM catalegpelicules WHERE titol = '" + title + "'");
                if (rs.next()) {
                    System.out.println("Titol: " + rs.getString("titol"));
                    System.out.println("Any: " + rs.getString("any"));
                    System.out.println("Director: " + rs.getString("director"));
                    System.out.println("Genero: " + rs.getString("genere"));
                    System.out.println("Duracio: " + rs.getString("duracio"));
                }
            } else {
                System.out.println("No existe la pelicula que deseas buscar, comprueba el titulo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void update(Pelicula pelicula, String titol) {
        String sql = "UPDATE catalegpelicules SET titol = ?, any = ?, director = ?, genere = ?, duracio = ? WHERE titol = " + titol;
        if (exists(titol)) preparedStatementConection(sql, pelicula);
    }
    @Override
    public void delete(String title) {
        try {
            if (exists(title)) {
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM catalegpelicules WHERE titol = ?");
                preparedStatement.setString(1, title);
                preparedStatement.executeUpdate();
                connection.close();
                System.out.println("Se ha borrado correctamente la pelicula" + title);
            } else {
                System.out.println("No existe la pelicula que deseas eliminar");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}