package com.aplicacio.webaplication.web;

import com.aplicacio.webaplication.Domini.Genere;
import com.aplicacio.webaplication.Domini.Pelicula;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private Connection connection;

    public void init() {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String number = request.getParameter("number");

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/prova", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
        List cataleg = llistarCataleg();
        PrintWriter out = response.getWriter();
        for (int i = 0; i < cataleg.size(); i++) {
            out.println(cataleg.get(i));
        }



    }

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

    public void destroy() {
    }
}