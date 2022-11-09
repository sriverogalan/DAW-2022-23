package com.controlproductes.servlets;

import com.controlproductes.data.IDataAccess;
import com.controlproductes.data.impl.MySQLImpl;
import com.controlproductes.domain.Producte;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "create", value = "/create")
public class CreateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String nom = req.getParameter("nom");
        String desc = req.getParameter("descripcio");
        double preu = Double.parseDouble(req.getParameter("preu"));
        Producte producte = new Producte(nom,preu, desc);
        IDataAccess dataAccess = new MySQLImpl();
        dataAccess.add(producte);
        resp.sendRedirect("controller?action=llistar");
    }
}
