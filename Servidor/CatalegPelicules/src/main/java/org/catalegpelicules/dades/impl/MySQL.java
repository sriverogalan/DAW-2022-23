package org.catalegpelicules.dades.impl;

import org.catalegpelicules.dades.IAccessDades;
import org.catalegpelicules.domini.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class MySQL implements IAccessDades {

    private Connection connection;

    public MySQL() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/prova", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pelicula> llistar() {
        List<Pelicula> llistaPelicules = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs_pelicules = statement.executeQuery("SELECT * FROM catalegpelicules");
            ResultSet rs_directors = statement.executeQuery("SELECT * FROM directors");
            ResultSet rs_generes = statement.executeQuery("SELECT * FROM generes");

            while (rs_pelicules.next()) {
            Pelicula pelicula = new Pelicula(rs_pelicules.getInt("id"), new Director(rs_directors.getInt("id")), new Genere(rs.getInt("genere")), rs.getString("titol"), rs.getInt("any"), rs.getInt("duracio"));
                llistaPelicules.add(pelicula);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return llistaPelicules;
    }

    @Override
    public boolean existeix(int id) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM catalegpelicules WHERE id LIKE '" + id + "'");
            if (resultSet.next()) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void crear(Pelicula pelicula) {
        try {
            if (!this.existeix(pelicula.getId())) {
                String sql = "INSERT INTO catalegpelicules (titol, any, director, genere,duracio) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                this.statementObject(preparedStatement, pelicula);
                preparedStatement.executeUpdate();
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cercar(String titol) {
        try {
            List<Pelicula> llista = this.llistar();
            for (Pelicula pelicula : llista) {
                if (pelicula.getTitol().equals(titol)) System.out.println(pelicula);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualitzar(int id, Pelicula pelicula) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("UPDATE catalegpelicules set titol = ?, any = ?, director = ?, genere = ?, duracio = ? WHERE id = " + id);
            this.statementObject(statement, pelicula);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrar(int id) {
        try {
            if (this.existeix(id)) {
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM catalegpelicules WHERE id = ?");
                preparedStatement.setInt(1, id);
                preparedStatement.execute();
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void tancarConexio() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void reiniciarCataleg() {
        try {
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM catalegpelicules");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void statementObject(PreparedStatement preparedStatement, Pelicula film) throws SQLException {
        preparedStatement.setString(1, film.getTitol());
        preparedStatement.setInt(2, film.getAny());
        preparedStatement.setString(3, film.getDirector());
        preparedStatement.setString(4, film.getGenero());
        preparedStatement.setInt(5, film.getDuracio());
    }
}