package org.catalegpelicules;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.catalegpelicules.dades.impl.MySQL;
import org.catalegpelicules.domini.Pelicula;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "film", value = "/film")
public class ServletPelicules extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

    }


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        int nPelicules = Integer.parseInt(req.getParameter("films"));
        List<Pelicula> pelicules = new ArrayList<>();
        MySQL mySQL = new MySQL();
        PrintWriter out = resp.getWriter();
        int contador = 0;

        if (mySQL.esMesGranQueLesPeliculesBD(nPelicules)) {
            out.println("<html><body><h1>El numero de peliculas que has introducido es mayor o menor que el numero de peliculas que hay en la base de datos</h1><a href='/web_war_exploded/'>Tornar</a></body></html>");
            return;
        }
        pelicules = mySQL.llistarPeliculesOrdenadesPerNom();

        out.println("<html><body>");
        out.println("<table>");
        out.println("   <tr>");
        out.println("       <th>Id</th>");
        out.println("       <th>Title</th>");
        out.println("       <th>Year</th>");
        out.println("       <th>Director</th>");
        out.println("       <th>Duration</th>");
        out.println("       <th>Gender</th>");
        out.println("   </tr>");
        for (Pelicula film : pelicules) {
            if (contador == nPelicules) break;
            out.println("   <tr>");
            out.println("       <td>" + film.getId() + "</td>");
            out.println("       <td>" + film.getTitol() + "</td>");
            out.println("       <td>" + film.getAny() + "</td>");
            out.println("       <td>" + film.getDirector() + "</td>");
            out.println("       <td>" + film.getDuracio() + "</td>");
            out.println("       <td>" + film.getGenere().getGenere() + "</td>");
            out.println("   </tr>");
            contador++;
        }
        out.println("</table>");
        out.println("<a href='/web_war_exploded/'>Tornar</a>");
        out.println("</body></html>");
    }


    public void destroy() {
    }
}