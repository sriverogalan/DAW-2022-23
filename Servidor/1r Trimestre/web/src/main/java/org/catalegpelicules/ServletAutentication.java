package org.catalegpelicules;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "autentication", value = "/autentication")
public class ServletAutentication extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String user = req.getParameter("nombre");
        String password = req.getParameter("password");
        PrintWriter out = resp.getWriter();
        if (user.equals("root") && password.equals("root")) {
            out.println(" <form action='film' method='post'> <label for='films'>Introduce el numero de peliculas que quieres ver: </label> <input type='number' placeholder='peliculas' name='films' id='films'/> <input type='submit' value='Film'/></form>");
        } else {
            out.println("<html><body>");
            out.println("<h1>Autenticació incorrecta</h1>");
            out.println("</body></html>");
        }
    }

    public void destroy() {
    }
}
