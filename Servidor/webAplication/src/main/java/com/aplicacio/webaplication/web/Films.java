package com.aplicacio.webaplication.web;

import com.aplicacio.webaplication.domini.Pelicula;
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
    private Connection connection;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");  
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdpelicules", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Pelicula> cataleg = llistarCataleg();
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>El catalago de peliculas es:</h1>");
        out.println("<table border=\"1\">");
        out.println("   <tr>");
        out.println("       <th>Id</th>");
        out.println("       <th>Titulo</th>");
        out.println("       <th>Año</th>");
        out.println("       <th>Genero</th>");
        out.println("       <th>Duracion</th>");
        out.println("   </tr>");
        for (Pelicula pelicula : cataleg) {
            out.println("   <tr>");
            out.println("       <td>" + pelicula.getId() + "</td>");
            out.println("       <td>" + pelicula.getTitol() + "</td>");
            out.println("       <td>" + pelicula.getAny() + "</td>");
            out.println("       <td>" + pelicula.getGenere() + "</td>");
            out.println("       <td>" + pelicula.getDuracio() + "</td>");
            out.println("   </tr>");
        }
        out.println("</table>");
        // imprimir taula de generos por pantalla por id y nombre
        



    }

    public List<Pelicula> llistarCataleg() {
        List<Pelicula> llistaPelicules = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM catalegpelicules");
            while (resultSet.next()) {
                Pelicula pelicula = new Pelicula(resultSet.getInt("id"), resultSet.getString("titol"), resultSet.getString("director"), resultSet.getString("genere"), resultSet.getInt("any"), resultSet.getInt("duracio"));
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