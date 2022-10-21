package org.catalegpelicules.dades.access;

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
    public List<Pelicula> llistarCataleg() {
        List<Pelicula> llistaPelicules = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs_pelicules = statement.executeQuery("SELECT * FROM catalegpelicules");
            ResultSet rs_directors = statement.executeQuery("SELECT * FROM directors");
            ResultSet rs_generes = statement.executeQuery("SELECT * FROM generes");

            while (rs_pelicules.next()) {
                Pelicula pelicula = new Pelicula(rs_pelicules.getInt("id"), new Director(rs_directors.getInt("id")), new Genere(rs_generes.getInt("id")), rs_pelicules.getString("titol"), rs_pelicules.getInt("any"), rs_pelicules.getInt("duracio"));
                llistaPelicules.add(pelicula);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return llistaPelicules;
    }

    @Override
    public boolean existeixCataleg(int id) {
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
    public boolean existeixGenere(int id) {
        return false;
    }

    @Override
    public boolean existeixDirector(int id) {
        return false;
    }

    @Override
    public void crearPelicules(Pelicula pelicula) {
        try {
            if (!this.existeixCataleg(pelicula.getId())) {
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
    public void crearGenere(Pelicula pelicula) {

    }

    @Override
    public void crearDirector(Pelicula pelicula) {

    }

    @Override
    public void cercarPelicula(String titol) {
        try {
            List<Pelicula> llista = this.llistarCataleg();
            for (Pelicula pelicula : llista) {
                if (pelicula.getTitol().equals(titol)) System.out.println(pelicula);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cercarGenere(String titol) {

    }

    @Override
    public void cercarDirector(String titol) {

    }

    @Override
    public void actualitzarPelicula(int id, Pelicula pelicula) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("UPDATE catalegpelicules set titol = ?, any = ?, director = ?, genere = ?, duracio = ? WHERE id = " + id);
            this.statementObject(statement, pelicula);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarPelicules(int id) {
        try {
            if (this.existeixCataleg(id)) {
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM catalegpelicules WHERE id = ?");
                preparedStatement.setInt(1, id);
                preparedStatement.execute();
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarGenere(int id) {

    }

    @Override
    public void borrarDirector(int id) {

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