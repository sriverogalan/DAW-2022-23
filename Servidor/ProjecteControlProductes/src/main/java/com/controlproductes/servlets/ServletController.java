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
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "controller", value = "/controller")
public class ServletController extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String action = req.getParameter("action");
        IDataAccess dataAccess = new MySQLImpl();
        List<Producte> productList = dataAccess.llistarProductes();
        switch (action) {
            case "llistar":
                req.setAttribute("productList", productList);
                req.getRequestDispatcher("llistaProductes.jsp").forward(req, resp);
                break;
            case "visualitza":
                int id = Integer.parseInt(req.getParameter("id"));
                Producte product = dataAccess.search(id);
                req.setAttribute("product", product);
                req.getRequestDispatcher("visualitzaProducte.jsp").forward(req, resp);
                break;
        }
    }
}
