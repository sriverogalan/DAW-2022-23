package org.catalegpelicules.dades.impl;

import org.catalegpelicules.dades.IAccessDades;
import org.catalegpelicules.domini.Genere;
import org.catalegpelicules.domini.Pelicula;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class MySQL implements IAccessDades {
    private Connection connection;

    public MySQL() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

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
            ResultSet rs_pelicules = statement.executeQuery("SELECT DISTINCT * FROM catalegpelicules, genere where catalegpelicules.id_genere = genere.id");
            while (rs_pelicules.next()) {
                Pelicula pelicula = new Pelicula(rs_pelicules.getInt("id"), new Genere(rs_pelicules.getInt("id_genere"), rs_pelicules.getString("genere")), rs_pelicules.getString("director"), rs_pelicules.getString("titol"), rs_pelicules.getInt("any"), rs_pelicules.getInt("duracio"));
                llistaPelicules.add(pelicula);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return llistaPelicules;
    }

    @Override
    public List<Pelicula> llistarCatalegOrdenatPerId() {
        List<Pelicula> llistaPelicules = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs_pelicules = statement.executeQuery("SELECT DISTINCT * FROM catalegpelicules, genere where catalegpelicules.id_genere = genere.id ORDER BY catalegpelicules.id");
            while (rs_pelicules.next()) {
                Pelicula pelicula = new Pelicula(rs_pelicules.getInt("id"), new Genere(rs_pelicules.getInt("id_genere"), rs_pelicules.getString("genere")), rs_pelicules.getString("director"), rs_pelicules.getString("titol"), rs_pelicules.getInt("any"), rs_pelicules.getInt("duracio"));
                llistaPelicules.add(pelicula);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return llistaPelicules;
    }

    @Override
    public List<Pelicula> llistarPeliculesOrdenadesPerNom() {
        List<Pelicula> llistaPelicules = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs_pelicules = statement.executeQuery("SELECT DISTINCT * FROM catalegpelicules, genere where catalegpelicules.id_genere = genere.id ORDER BY catalegpelicules.titol");
            while (rs_pelicules.next()) {
                Pelicula pelicula = new Pelicula(rs_pelicules.getInt("id"), new Genere(rs_pelicules.getInt("id_genere"), rs_pelicules.getString("genere")), rs_pelicules.getString("director"), rs_pelicules.getString("titol"), rs_pelicules.getInt("any"), rs_pelicules.getInt("duracio"));
                llistaPelicules.add(pelicula);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return llistaPelicules;
    }
    @Override
    public List<Pelicula> llistarPeliculesOrdenadesPerAny() {
        List<Pelicula> llistaPelicules = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs_pelicules = statement.executeQuery("SELECT DISTINCT * FROM catalegpelicules, genere where catalegpelicules.id_genere = genere.id ORDER BY catalegpelicules.any");
            while (rs_pelicules.next()) {
                Pelicula pelicula = new Pelicula(rs_pelicules.getInt("id"), new Genere(rs_pelicules.getInt("id_genere"),rs_pelicules.getString("genere")), rs_pelicules.getString("director"), rs_pelicules.getString("titol"), rs_pelicules.getInt("any"), rs_pelicules.getInt("duracio"));
                llistaPelicules.add(pelicula);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return llistaPelicules;
    }

    @Override
    public List<Pelicula> llistarPeliculesOrdenadesPerDurada() {
        List<Pelicula> llistaPelicules = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs_pelicules = statement.executeQuery("SELECT DISTINCT * FROM catalegpelicules, genere where catalegpelicules.id_genere = genere.id ORDER BY catalegpelicules.duracio");
            while (rs_pelicules.next()) {
                Pelicula pelicula = new Pelicula(rs_pelicules.getInt("id"), new Genere(rs_pelicules.getInt("id_genere"), rs_pelicules.getString("genere")), rs_pelicules.getString("director"), rs_pelicules.getString("titol"), rs_pelicules.getInt("any"), rs_pelicules.getInt("duracio"));
                llistaPelicules.add(pelicula);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return llistaPelicules;
    }
    @Override
    public List<Pelicula> llistarPeliculesOrdenadesPerDirector() {
        List<Pelicula> llistaPelicules = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs_pelicules = statement.executeQuery("SELECT DISTINCT * FROM catalegpelicules, genere where catalegpelicules.id_genere = genere.id ORDER BY catalegpelicules.director");
            while (rs_pelicules.next()) {
                Pelicula pelicula = new Pelicula(rs_pelicules.getInt("id"), new Genere(rs_pelicules.getInt("id_genere"), rs_pelicules.getString("genere")), rs_pelicules.getString("director"), rs_pelicules.getString("titol"), rs_pelicules.getInt("any"), rs_pelicules.getInt("duracio"));
                llistaPelicules.add(pelicula);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return llistaPelicules;
    }
    @Override
    public List<Pelicula> llistarPeliculesOrdenadesPerGenere() {
        List<Pelicula> llistaPelicules = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs_pelicules = statement.executeQuery("SELECT DISTINCT * FROM catalegpelicules, genere where catalegpelicules.id_genere = genere.id ORDER BY genere.genere");
            while (rs_pelicules.next()) {
                Pelicula pelicula = new Pelicula(rs_pelicules.getInt("id"), new Genere(rs_pelicules.getInt("id_genere"), rs_pelicules.getString("genere")), rs_pelicules.getString("director"), rs_pelicules.getString("titol"), rs_pelicules.getInt("any"), rs_pelicules.getInt("duracio"));
                llistaPelicules.add(pelicula);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return llistaPelicules;
    }

    @Override
    public List<Genere> llistarGeneres() {
        List<Genere> llistaGeneres = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs_generes = statement.executeQuery("SELECT * FROM genere");
            while (rs_generes.next()) {
                Genere genere = new Genere(rs_generes.getInt("id"), rs_generes.getString("genere"));
                llistaGeneres.add(genere);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return llistaGeneres;
    }
    @Override
    public void crearGenere(String genere) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO genere VALUES (DEFAULT, '" + genere + "')");
            System.out.println("Genere creat");
        } catch (SQLException e) {
            e.printStackTrace();
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
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM genere WHERE id LIKE '" + id + "'");
            if (resultSet.next()) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public void crearPelicules(Pelicula pelicula) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO catalegpelicules VALUES  (DEFAULT, '" + pelicula.getGenere().getId() + "', '" + pelicula.getDirector() + "', '" + pelicula.getTitol() + "', '" + pelicula.getAny() + "', '" + pelicula.getDuracio() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void cercarPelicula(int id) {
        try {
            List<Pelicula> llista = this.llistarCataleg();
            for (Pelicula pelicula : llista) {
                if (pelicula.getId() == id) {
                    System.out.println(pelicula);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void borrarPelicula(int id) {
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
        try {
            if (this.existeixGenere(id)) {
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM genere WHERE id = ?");
                preparedStatement.setInt(1, id);
                preparedStatement.execute();
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void actualitzarPelicula(int id, Pelicula pelicula) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE catalegpelicules SET id_genere = '" + pelicula.getGenere().getId() + "', director = '" + pelicula.getDirector() + "', titol = '" + pelicula.getTitol() + "', any = '" + pelicula.getAny() + "', duracio = '" + pelicula.getDuracio() + "' WHERE id = '" + id + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void actualitzarGenere(int id, Genere genere) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE genere SET genere = '" + genere.getGenere() + "' WHERE id = '" + id + "'");
        } catch (SQLException exception) {
            exception.printStackTrace();
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
    public boolean esMesGranQueLesPeliculesBD(int num) {
        if (num > this.llistarCataleg().size()) return true;
        return false;
    }
}