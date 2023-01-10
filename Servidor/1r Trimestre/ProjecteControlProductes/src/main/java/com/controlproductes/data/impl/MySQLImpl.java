package com.controlproductes.data.impl;

import com.controlproductes.data.IDataAccess;
import com.controlproductes.domain.Producte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLImpl implements IDataAccess {

    private Connection conn;

    public MySQLImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Botiga", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Producte> llistarProductes() {
        List<Producte> productes = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM articles");
            while (rs.next()) {
                productes.add(new Producte(rs.getInt("id"), rs.getString("nom"), rs.getDouble("preu"), rs.getString("descripcio")));
            }
            return productes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productes;
    }

    @Override
    public Producte search(int id) {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM articles WHERE id = " + id);
            if (rs.next()) {
                return new Producte(rs.getInt("id"), rs.getString("nom"), rs.getDouble("preu"), rs.getString("descripcio"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void add(Producte product) {
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("INSERT INTO articles (nom, preu, descripcio) VALUES ('" + product.getNom() + "', " + product.getPreu() + ", '" + product.getDescripcio() + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, Producte product) {
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("UPDATE articles SET nom = '" + product.getNom() + "', preu = " + product.getPreu() + ", descripcio = '" + product.getDescripcio() + "' WHERE id = " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drop(int id) {
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM articles WHERE id = " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}