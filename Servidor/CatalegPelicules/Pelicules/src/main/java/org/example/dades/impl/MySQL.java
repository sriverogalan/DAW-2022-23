package org.example.dades.impl;

import org.example.dades.IAccessDades;
import org.example.domini.Pelicula;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class MySQL implements IAccessDades {

    private Connection connection;

    public MySQL() {
        try {
            String url = "jdbc:mysql://localhost:3306/cataleg";
            this.connection = DriverManager.getConnection(url, "root", "root");
            System.out.println("Se ha conectado correctamente a la base de datos");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Pelicula> llistar() {
        List<Pelicula> llistaPelicules = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM films");
            while (rs.next()) {
                Pelicula pelicula = new Pelicula(rs.getInt("id"), rs.getString("title"), rs.getInt("year"), rs.getString("director"), rs.getString("gender"), rs.getInt("duration"));
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
            ResultSet resultSet = statement.executeQuery("SELECT * FROM films WHERE id LIKE '" + id + "'");
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
                String sql = "INSERT INTO catalegpelicules (title, year, director, gender, duration) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                this.statementObject(preparedStatement, pelicula);
                preparedStatement.executeUpdate();
                System.out.println("Pelicula creada");
                return;
            }
            System.out.println("La pelicula ja existeix");
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
            PreparedStatement statement = this.connection.prepareStatement("UPDATE films set title = ?, year = ?, director = ?, gender = ?, duration = ? WHERE id = " + id);
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
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM films WHERE id = ?");
                preparedStatement.setInt(1, id);
                preparedStatement.execute();
                System.out.println("Se ha borrado correctamente la pelicula");
                return;
            }
            System.out.println("La pelicula no existeix");
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
            statement.execute("DROP TABLE IF EXISTS films");
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