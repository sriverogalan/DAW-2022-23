package org.catalegpelicules.dades.access.impl;
import org.catalegpelicules.dades.access.IAccessDades;
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
            ResultSet rs_generes = statement.executeQuery("SELECT * FROM generes");
            while (rs_pelicules.next()) {
                Pelicula pelicula = new Pelicula(rs_pelicules.getInt("id"),  rs_pelicules.getString("director"), new Genere(rs_generes.getInt("id"),rs_generes.getString("nom")), rs_pelicules.getString("titol"), rs_pelicules.getInt("any"), rs_pelicules.getInt("duracio"));
                llistaPelicules.add(pelicula);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return llistaPelicules;
    }

    @Override
    public void actualitzarPelicula(int id, Pelicula pelicula) {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs_pelicules = statement.executeQuery("SELECT * FROM catalegpelicules WHERE id = " + id);
            if (rs_pelicules.next()) {
                statement.executeUpdate("UPDATE catalegpelicules SET director = '" + pelicula.getId() + "', genere = '" + pelicula.getGenere().getId() + "', titol = '" + pelicula.getTitol() + "', any = '" + pelicula.getAny() + "', duracio = '" + pelicula.getDuracio() + "' WHERE id = " + id + "ON UPDATE CASCADE") ;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void actualitzarPelicula(int id, Genere genere) {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs_generes = statement.executeQuery("SELECT * FROM generes WHERE id = " + id);
            if (rs_generes.next()) {
                statement.executeUpdate("UPDATE generes SET nom = '" + genere.getNom() + "' WHERE id = " + id);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
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
    public void crearPelicules(Pelicula pelicula) {
    }

    @Override
    public void crearGenere(Pelicula pelicula) {

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
        preparedStatement.setString(1, film.getDirector());
        preparedStatement.setInt(2, film.getGenere().getId());
        preparedStatement.setString(3, film.getTitol());
        preparedStatement.setInt(4, film.getAny());
        preparedStatement.setInt(5, film.getDuracio());
    }
}